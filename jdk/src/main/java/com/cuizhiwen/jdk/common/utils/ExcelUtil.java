package com.cuizhiwen.jdk.common.utils;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Title: ExcelUtil 描述: Excel上传下载工具
 * @author guoliwei
 * @since 1.0.0
 */
@Slf4j
@Component
public final class ExcelUtil {
    
    private static String RESULT_FILE_PATH;
    
    /**
     * 构造
     */
    private ExcelUtil() {
        
    }
    
    /**
     * 导入Excel
     * 
     * @param filePath
     *            文件路径
     * @param titleRows
     *            表格标题行数
     * @param headerRows
     *            表头行数
     * @param pojoClass
     *            导入数据转换目标对象
     * @param <T>
     *            导入数据转换目标对象
     * @return 导入数据转换为目标对象数组
     */
    public static <T> List<T> importExcel(final String filePath, final Integer titleRows, final Integer headerRows,
            final Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (final NoSuchElementException e) {
            log.error(e.getMessage(), e);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }
    /**
     * 导入
     * @param file  文件
     * @param titleRows  表格标题行数,默认0
     * @param headerRows 表头行数,默认1
     * @param pojoClass  实体类
     * @return  导入实体
     */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows,
                                          Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     *
     * @param title 标题名称
     * @param sheetName sheet名称
     * @param entity   list 中实体类
     * @param list     集合
     * @param fileName 文件名称（不含.xls）
     * @param response
     * @param isSave 是否保存到本地
     */
    public static  <T> void exportExcel(String title, String sheetName, Class<T> entity, List<T> list, final String fileName, final
    HttpServletResponse response, boolean isSave){
        String resultfileName =fileName + ".xls";
        ExportParams exportParams = new ExportParams(title, sheetName , ExcelType.XSSF);
        exportParams.setStyle(ExcelStyleUtil.class);
        Workbook workbook =   ExcelExportUtil.exportExcel(exportParams,entity,
                list);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            // 保存Excel文件到本地
            if (isSave) {
                File saveFile = new File("D:/excel/");
                if (!saveFile.exists()) {
                    saveFile.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream("D:/excel/" + File.separator + resultfileName);
                workbook.write(fos);
                fos.close();
            } else {
                // 直接下载Excel文件,不保存
                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-Type", "application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                        "attachment;filename=" + URLEncoder.encode(resultfileName, "UTF-8"));
                workbook.write(response.getOutputStream());
            }

        } catch (final IOException e) {
            log.error(e.getMessage(), e);
        }finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /* @Value("${import.excel.result.url}") */
    public void setResultFilePath(final String resultFilePath) {
        ExcelUtil.RESULT_FILE_PATH = resultFilePath;
    }
    
    /**
     * 导入Excel
     * 
     * @param inputStream
     *            数据流导入
     * @param titleRows
     *            表格标题行数
     * @param headerRows
     *            表头行数
     * @param entity
     *            导入数据转换目标对象
     * @return 导入数据转换为目标对象数组
     * @throws Exception
     *             excel 值异常
     */
    public static <T> List<T> importExcel(InputStream inputStream, int titleRows, int headerRows, Class<T> entity)
            throws Exception {
        // TODO Auto-generated method stub
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        list = ExcelImportUtil.importExcel(inputStream, entity, params);
        return list;
    }
    
    /**
     * 校验导入文件是否为excel
     * 
     * @param fileName
     *            导入文件名称
     * @return true or false
     */
    public static boolean verifyXlsOrXlsx(final String fileName) {
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            return false;
        }
        return true;
    }
}
