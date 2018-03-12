package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.time.Month;

/**
 * Created by pengbo on 18-3-8.
 */
public class MonthTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            Month month = (Month)o;
            parameterSetter.setInt(month.getValue());
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Object monthObject = resultGetter.getObject();
        int month = monthObject == null ? 0 : (int)monthObject;
        return month != 0 ? Month.of(month) : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
