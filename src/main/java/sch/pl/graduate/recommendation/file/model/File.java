/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.file.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class File extends AbstractModel{
    private Long fileKey;
    private String fileName;
    private String filePath;
    private FileType fileType;
    private Long size;
    private String format;
}
