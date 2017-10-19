/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-19
 */
package sch.pl.graduate.recommendation.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Time;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
public class SqlTimeSerializer extends JsonSerializer<Time> {

    @Override
    public void serialize(Time value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }

}
