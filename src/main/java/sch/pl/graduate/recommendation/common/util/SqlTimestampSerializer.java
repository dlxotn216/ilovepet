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
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Lee Tae Su on 2017-10-19.
 */
@Component
public class SqlTimestampSerializer extends JsonSerializer<Timestamp> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    @Override
    public void serialize(Timestamp value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        String formattedDate = dateFormat.format(value);
        generator.writeString(formattedDate);
    }

}
