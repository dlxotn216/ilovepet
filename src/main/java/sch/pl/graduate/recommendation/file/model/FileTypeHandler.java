/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.file.model;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public class FileTypeHandler  extends BaseTypeHandler<FileType> {

    @Override
    public FileType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int code = resultSet.getInt(columnName);
        return FileType.get(code);
    }

    @Override
    public FileType getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int code = resultSet.getInt(columnIndex);
        return FileType.get(code);
    }

    @Override
    public FileType getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int code = callableStatement.getInt(columnIndex);
        return FileType.get(code);
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int integer, FileType type,
                                    JdbcType jdbcType) throws SQLException {
        if (type != null) {
            preparedStatement.setInt(integer, type.getCode());
        }
    }

}
