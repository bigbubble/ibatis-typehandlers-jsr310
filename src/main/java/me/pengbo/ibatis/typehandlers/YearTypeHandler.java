package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.time.Year;

/**
 * Created by pengbo on 18-3-8.
 */
public class YearTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            Year year = (Year)o;
            parameterSetter.setInt(year.getValue());
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Object yearObject = resultGetter.getObject();
        int year = yearObject == null ? 0 : (int)yearObject;
        return year == 0 ? null : Year.of(year);
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
