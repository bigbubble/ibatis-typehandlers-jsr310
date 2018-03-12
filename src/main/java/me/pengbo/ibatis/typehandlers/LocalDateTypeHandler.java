package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by pengbo on 18-3-8.
 */
public class LocalDateTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            LocalDate localDate = (LocalDate)o;
            parameterSetter.setDate(Date.valueOf(localDate));
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Date date = resultGetter.getDate();
        return date != null ? date.toLocalDate() : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
