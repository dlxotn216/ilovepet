/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-18
 */
package sch.pl.graduate.recommendation.common.model;

import lombok.Data;
import org.springframework.util.StringUtils;
import sch.pl.graduate.recommendation.common.exception.SystemException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Tae Su on 2017-10-18.
 */
@Data
public abstract class AbstractCriteria {
    private static final String ORDER_ASC = "ASC";
    private static final String ORDER_DESC = "DESC";
    private static final int DEFAULT_OFFSET = 0;
    private static final int DEFAULT_LIMIT = 12;
    private static final int DEFAULT_PAGE = 1;

    private static final Map<String, String> DEFAULT_MAPPING_FILEDS;

    static {
        Map<String, String> aMap = new HashMap<>();

        DEFAULT_MAPPING_FILEDS = Collections.unmodifiableMap(aMap);
    }

    protected static final String SPLIT_REGEX = ",";

    private String keyword;
    private String target;
    private String[] arrTarget = new String[]{};

    private Integer page = DEFAULT_PAGE;
    private Integer limit = DEFAULT_LIMIT;
    private Integer offset = DEFAULT_OFFSET;

    private String order;
    private String[] arrOrder = new String[]{};

    private String sort;
    private String[] arrSort = new String[]{};

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        if(!StringUtils.isEmpty(target)) {
            arrTarget = target.split(SPLIT_REGEX);
        } else {
            arrTarget = new String[]{};
        }

        convertArrayFieldToColumn(arrTarget);

        this.target = target;
    }

    public String[] getArrTarget() {
        return arrTarget;
    }

    public void setArrTarget(String[] arrTarget) {
        this.arrTarget = arrTarget;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return (page-1)*limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if(!StringUtils.isEmpty(order)) {
            arrOrder = order.split(SPLIT_REGEX);
        }

        if(arrOrder != null && arrOrder.length > 0) {
            for(String arrOrderStr : arrOrder) {
                String orderStr = arrOrderStr.toUpperCase().trim();
                if(!ORDER_ASC.equals(orderStr) && !ORDER_DESC.equals(orderStr)) {
                    throw new SystemException("파라미터가 잘못 되었습니다");
                }
            }
        }
        this.order = order;
    }

    public String[] getArrOrder() {
        return arrOrder;
    }

    public void setArrOrder(String[] arrOrder) {
        this.arrOrder = arrOrder;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        if(!StringUtils.isEmpty(sort)) {
            arrSort = sort.split(SPLIT_REGEX);
        }

        convertArrayFieldToColumn(arrSort);

        this.sort = sort;
    }

    public String[] getArrSort() {
        return arrSort;
    }

    public void setArrSort(String[] arrSort) {
        this.arrSort = arrSort;
    }

    public abstract String convertFieldToColumn(String field);

    private void convertArrayFieldToColumn(String[] strings) {
        for(int i = 0; i < strings.length; i++) {
            String field = strings[i].trim();
            String column = convertFieldToColumn(field);
            if(StringUtils.isEmpty(column)) {
                column = DEFAULT_MAPPING_FILEDS.get(field);
                if(StringUtils.isEmpty(column)) {
                    throw new SystemException("파라미터가 잘못 되었습니다");
                }
            }
            strings[i] = column;
        }
    }

    class LocalDateTime {
        private int year = -1;
        private int monthOfYear = -1;
        private int dayOfMonth = -1;
        private int hourOfDay = -1;
        private int minuteOfHour = -1;
        private int secondOfMinute = -1;

        public LocalDateTime() {

        }

        LocalDateTime(
                int year,
                int monthOfYear,
                int dayOfMonth,
                int hourOfDay,
                int minuteOfHour,
                int secondOfMinute) {
            super();
            this.year = year;
            this.monthOfYear = monthOfYear;
            this.dayOfMonth = dayOfMonth;
            this.hourOfDay = hourOfDay;
            this.minuteOfHour = minuteOfHour;
            this.secondOfMinute = secondOfMinute;
        }

        int getYear() {
            return year;
        }

        void setYear(int year) {
            this.year = year;
        }

        int getMonthOfYear() {
            return monthOfYear;
        }

        void setMonthOfYear(int monthOfYear) {
            this.monthOfYear = monthOfYear;
        }

        int getDayOfMonth() {
            return dayOfMonth;
        }

        void setDayOfMonth(int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
        }

        int getHourOfDay() {
            return hourOfDay;
        }

        void setHourOfDay(int hourOfDay) {
            this.hourOfDay = hourOfDay;
        }

        int getMinuteOfHour() {
            return minuteOfHour;
        }

        void setMinuteOfHour(int minuteOfHour) {
            this.minuteOfHour = minuteOfHour;
        }

        int getSecondOfMinute() {
            return secondOfMinute;
        }

        void setSecondOfMinute(int secondOfMinute) {
            this.secondOfMinute = secondOfMinute;
        }
    }

    private LocalDateTime getLocalDateTime(String localDateTimeString) {
        String[] splitedDateTime = localDateTimeString.split(" ");
        String[] splitedDay = splitedDateTime[0].split("/");
        String[] splitedTime = splitedDateTime[1].split(":");

        int year = Integer.parseInt(splitedDay[0]);
        int monthOfYear = Integer.parseInt(splitedDay[1]);
        int dayOfMonth = Integer.parseInt(splitedDay[2]);
        int hourOfDay = Integer.parseInt(splitedTime[0]);
        int minuteOfHour = Integer.parseInt(splitedTime[1]);
        int secondOfMinute = Integer.parseInt(splitedTime[2]);

        return new LocalDateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute);
    }

}
