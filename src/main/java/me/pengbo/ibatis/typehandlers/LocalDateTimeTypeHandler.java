package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by pengbo on 18-3-8.
 */
public class LocalDateTimeTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            LocalDateTime localDateTime = (LocalDateTime)o;
            parameterSetter.setTimestamp(Timestamp.valueOf(localDateTime));
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Timestamp timestamp = resultGetter.getTimestamp();
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
