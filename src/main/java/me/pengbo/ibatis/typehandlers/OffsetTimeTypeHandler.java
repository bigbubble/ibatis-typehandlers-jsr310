package me.pengbo.ibatis.typehandlers;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

import java.sql.SQLException;
import java.sql.Time;
import java.time.OffsetTime;

/**
 * Created by pengbo on 18-3-8.
 */
public class OffsetTimeTypeHandler implements TypeHandlerCallback{
    @Override
    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if(o != null){
            OffsetTime offsetTime = (OffsetTime)o;
            parameterSetter.setTime(Time.valueOf(offsetTime.toLocalTime()));
        }else{
            parameterSetter.setObject(null);
        }
    }

    @Override
    public Object getResult(ResultGetter resultGetter) throws SQLException {
        Time time = resultGetter.getTime();
        return time != null ? time.toLocalTime().atOffset(OffsetTime.now().getOffset()) : null;
    }

    @Override
    public Object valueOf(String s) {
        return null;
    }
}
