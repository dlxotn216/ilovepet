/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.common.model;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public class GenderTypeHandler extends BaseTypeHandler<GenderType> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int integer, GenderType type, JdbcType jdbcType)
            throws SQLException {
        if (type != null) {
            preparedStatement.setInt(integer, type.getCode());
        }
    }

    @Override
    public GenderType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int code = resultSet.getInt(columnName);
        return GenderType.get(code);
    }

    @Override
    public GenderType getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int code = resultSet.getInt(columnIndex);
        return GenderType.get(code);
    }

    @Override
    public GenderType getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int code = callableStatement.getInt(columnIndex);
        return GenderType.get(code);
    }

}