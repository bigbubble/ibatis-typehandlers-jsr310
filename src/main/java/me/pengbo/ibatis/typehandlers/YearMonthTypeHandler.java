package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.time.YearMonth;

/**
 * Created by pengbo on 18-3-8.
 */
public class YearMonthTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            YearMonth yearMonth = (YearMonth)o;
            parameterSetter.setString(yearMonth.toString());
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        String yearMonth = resultGetter.getString();
        return yearMonth != null ? YearMonth.parse(yearMonth) : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
