package gnnt.MEBS.timebargain.broker.action.tariff;

import gnnt.MEBS.common.broker.action.StandardAction;
import gnnt.MEBS.common.broker.common.Condition;
import gnnt.MEBS.common.broker.common.Page;
import gnnt.MEBS.common.broker.common.PageRequest;
import gnnt.MEBS.common.broker.common.QueryConditions;
import gnnt.MEBS.common.broker.model.StandardModel;
import gnnt.MEBS.common.broker.service.StandardService;
import gnnt.MEBS.common.broker.statictools.Tools;
import gnnt.MEBS.timebargain.broker.service.tariff.TariffService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.ecside.core.ECSideContext;
import org.ecside.table.limit.Filter;
import org.ecside.table.limit.FilterSet;
import org.ecside.table.limit.Limit;
import org.ecside.table.limit.Sort;
import org.ecside.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ECSideAction
  extends StandardAction
{
  @Autowired
  @Qualifier("com_tariffService")
  private TariffService ts;
  
  protected String listByLimit(PageRequest<QueryConditions> paramPageRequest, Object paramObject)
    throws Exception
  {
    this.logger.debug("enter listByLimit");
    List localList = getECSideQueryConditions();
    if ((localList != null) && (localList.size() > 0)) {
      if (((QueryConditions)paramPageRequest.getFilters()).getConditionList() != null) {
        ((QueryConditions)paramPageRequest.getFilters()).getConditionList().addAll(localList);
      } else {
        ((QueryConditions)paramPageRequest.getFilters()).setConditionList(localList);
      }
    }
    String str1 = getEcisdeSortColumns();
    if ((str1 != null) && (str1.length() > 0))
    {
      String str2 = paramPageRequest.getSortColumns();
      if ((str2 != null) && (str2.trim().length() > 0)) {
        str2 = " order by " + str1 + "," + str2.replace("order by", "");
      } else {
        str2 = " order by " + str1;
      }
      paramPageRequest.setSortColumns(str2);
    }
    int i = 10000;
    if (!isExported())
    {
      paramPageRequest.setPageNumber(getEcsidePageNumber());
      paramPageRequest.setPageSize(getEcsidePageSize());
    }
    else
    {
      paramPageRequest.setPageNumber(1);
      paramPageRequest.setPageSize(i);
    }
    Page localPage = null;
    if ((paramObject instanceof StandardModel)) {
      localPage = getService().getPage(paramPageRequest, (StandardModel)paramObject);
    } else if ((paramObject instanceof String)) {
      localPage = this.ts.getPage(paramPageRequest, (String)paramObject);
    } else {
      throw new IllegalArgumentException("不是实体类，也不是表名");
    }
    if ((!isExported()) || (localPage.getTotalCount() <= i))
    {
      this.request.setAttribute("pageInfo", localPage);
      this.request.setAttribute("oldParams", getParametersStartingWith(this.request, "gnnt_"));
      setECSideRowAttributes(localPage.getTotalCount());
    }
    return "success";
  }
  
  protected String listByLimit(PageRequest<QueryConditions> paramPageRequest, String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    this.logger.debug("enter listByLimit");
    List localList = getECSideQueryConditions();
    if ((localList != null) && (localList.size() > 0)) {
      if (((QueryConditions)paramPageRequest.getFilters()).getConditionList() != null) {
        ((QueryConditions)paramPageRequest.getFilters()).getConditionList().addAll(localList);
      } else {
        ((QueryConditions)paramPageRequest.getFilters()).setConditionList(localList);
      }
    }
    String str1 = getEcisdeSortColumns();
    if ((str1 != null) && (str1.length() > 0))
    {
      String str2 = paramPageRequest.getSortColumns();
      if ((str2 != null) && (str2.trim().length() > 0)) {
        str2 = " order by " + str1 + "," + str2.replace("order by", "");
      } else {
        str2 = " order by " + str1;
      }
      paramPageRequest.setSortColumns(str2);
    }
    int i = 10000;
    if (!isExported())
    {
      paramPageRequest.setPageNumber(getEcsidePageNumber());
      paramPageRequest.setPageSize(getEcsidePageSize());
    }
    else
    {
      paramPageRequest.setPageNumber(1);
      paramPageRequest.setPageSize(i);
    }
    Page localPage = this.ts.getPageSurroundSql(paramPageRequest, paramString1, paramString2, paramString3);
    if ((!isExported()) || (localPage.getTotalCount() <= i))
    {
      this.request.setAttribute("pageInfo", localPage);
      this.request.setAttribute("oldParams", getParametersStartingWith(this.request, "gnnt_"));
      setECSideRowAttributes(localPage.getTotalCount());
    }
    return "success";
  }
  
  private boolean isExported()
  {
    boolean bool = false;
    Limit localLimit = RequestUtils.getLimit(this.request);
    if (localLimit.isExported()) {
      bool = true;
    }
    return bool;
  }
  
  private int getEcsidePageNumber()
  {
    int i = RequestUtils.getPageNo(this.request);
    if (i <= 0) {
      i = 1;
    }
    return i;
  }
  
  private int getEcsidePageSize()
  {
    int i = RequestUtils.getCurrentRowsDisplayed(this.request);
    if (i <= 0) {
      i = ECSideContext.DEFAULT_PAGE_SIZE;
    }
    return i;
  }
  
  private void setECSideRowAttributes(int paramInt)
  {
    Limit localLimit = RequestUtils.getLimit(this.request);
    localLimit.setRowAttributes(paramInt, ECSideContext.DEFAULT_PAGE_SIZE);
  }
  
  private List<Condition> getECSideQueryConditions()
    throws Exception
  {
    this.logger.debug("通过 Ecside 获取查询条件");
    ArrayList localArrayList = new ArrayList();
    Limit localLimit = RequestUtils.getLimit(this.request);
    FilterSet localFilterSet = localLimit.getFilterSet();
    Filter[] arrayOfFilter1 = localFilterSet.getFilters();
    if ((arrayOfFilter1 != null) && (arrayOfFilter1.length > 0))
    {
      Pattern localPattern1 = Pattern.compile("\\[(.+)]\\[(.+)]");
      Pattern localPattern2 = Pattern.compile("\\[(.+)]");
      for (Filter localFilter : arrayOfFilter1)
      {
        String str1 = localFilter.getProperty();
        Object localObject = localFilter.getValue();
        String str2 = "=";
        String str3 = localFilter.getAlias();
        if ((str3 != null) && (str3.length() > 0))
        {
          String str4 = null;
          Matcher localMatcher = localPattern1.matcher(str3);
          if (localMatcher.matches())
          {
            str2 = localMatcher.group(1);
            str4 = localMatcher.group(2);
          }
          else
          {
            localMatcher = localPattern2.matcher(str3);
            if (localMatcher.matches()) {
              str2 = localMatcher.group(1);
            }
          }
          if ((str4 != null) && (str4.length() > 0)) {
            localObject = Tools.convert(localObject, str4);
          }
        }
        localArrayList.add(new Condition(str1, str2, localObject));
      }
    }
    return localArrayList;
  }
  
  private String getEcisdeSortColumns()
  {
    this.logger.debug("通过 Ecside 获取排序方案");
    Limit localLimit = RequestUtils.getLimit(this.request);
    Sort localSort = localLimit.getSort();
    String str1 = localSort.getProperty();
    String str2 = localSort.getSortOrder();
    if ((str1 == null) || (str1.trim().length() <= 0)) {
      return null;
    }
    if ((str2 == null) || (str2.trim().length() <= 0)) {
      return null;
    }
    if (!"desc".equalsIgnoreCase(str2)) {
      str2 = "";
    }
    return str1 + " " + str2;
  }
}
