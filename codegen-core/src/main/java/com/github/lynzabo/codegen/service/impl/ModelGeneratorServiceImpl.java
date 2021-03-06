/**
 * Copyright (c) 2016 乐视云计算有限公司（lecloud.com）. All rights reserved
 */
package com.github.lynzabo.codegen.service.impl;

import com.github.lynzabo.codegen.except.CodegenException;
import com.github.lynzabo.codegen.model.GenDTO;
import com.github.lynzabo.codegen.model.ModelDTO;
import com.github.lynzabo.codegen.model.RenderDataDTO;
import com.github.lynzabo.codegen.service.Generator;
import com.github.lynzabo.codegen.supports.CodegenConfig;
import com.github.lynzabo.codegen.supports.FreemarkerUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.*;

/**
 * Model类文件生成
 * @author linzhanbo .
 * @since 2016年11月17日, 16:59 .
 * @version 1.0 .
 */
@Service("modelGeneratorService")
public class ModelGeneratorServiceImpl extends AbstractGeneratorServiceImpl implements Generator {
    public void render() {
        GenDTO genDTO = CodegenConfig.getInstance().getGenDTO();
        ModelDTO modelDTO = genDTO.getModelDTO();
        RenderDataDTO renderDataDTO = genDTO.getRenderDataDTO();
        Map<String,Object> dataItems = new HashMap<String,Object>();
        Collection<RenderDataDTO.Column> columns = renderDataDTO.getColumns().values();
        //ftl需要
        dataItems.put("modelPackage",getModelPackage());

        Set<String> importSets = new HashSet<String>();
        for (RenderDataDTO.Column column : columns) {
            String value = column.getJavaType();
            if(value.contains("."))
                importSets.add("import "+value+";");
            /*if ("BigDecimal".equals(value) && !importSets.contains("BigDecimal")) {
                importSets.add("import java.math.BigDecimal;");
            } else if ("Date".equals(value) && !importSets.contains("Date")) {
                importSets.add("import java.util.Date;");
            } else if ("Timestamp".equals(value) && !importSets.contains("Timestamp")) {
                importSets.add("import java.sql.Timestamp;");
            } else if ("Time".equals(value) && !importSets.contains("Time")) {
                importSets.add("import java.sql.Time;");
            }*/
        }
        dataItems.put("imports",importSets);

        dataItems.put("entityName", getEntityName());
        dataItems.put("modelDescription", getModelDescription());

        dataItems.put("columns", columns);
        //model properties
        Map modelPropsMap = modelDTO.getProperties();
        if(!CollectionUtils.isEmpty(modelPropsMap))
            dataItems.putAll(modelPropsMap);
        //global properties
        Map globalPropsMaps = CodegenConfig.getInstance().getProperties();
        if(!CollectionUtils.isEmpty(globalPropsMaps))
            dataItems.putAll(globalPropsMaps);
        try {
            FreemarkerUtil.renderToFile(dataItems, modelDTO.getFtl(), MessageFormat.format("{0}/{1}/{2}.java", getModelLocation(), getModelPackage().replace(".", "/"), getEntityName()));
        } catch (Exception e) {
            throw new CodegenException(e);
        }
    }
}
