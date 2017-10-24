/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-24
 */
package sch.pl.graduate.recommendation.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;
import sch.pl.graduate.recommendation.common.exception.SystemException;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lee Tae Su on 2017-10-24.
 */
@Component
public class SqlTimestampDeserializer extends JsonDeserializer<Timestamp> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    @Override
    public Timestamp deserialize(final JsonParser jsonParser, final DeserializationContext ctxt) throws IOException {
        String dateString = jsonParser.getText();
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new SystemException("Date parse error");
        }
        return new Timestamp(date.getTime());
    }

}
