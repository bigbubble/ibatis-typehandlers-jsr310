package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;

/**
 * Created by pengbo on 18-3-8.
 */
public class OffsetDateTimeTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            OffsetDateTime offsetDateTime = (OffsetDateTime)o;
            parameterSetter.setTimestamp(Timestamp.from(offsetDateTime.toInstant()));
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Timestamp timestamp = resultGetter.getTimestamp();
        return timestamp != null ? OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()) : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
