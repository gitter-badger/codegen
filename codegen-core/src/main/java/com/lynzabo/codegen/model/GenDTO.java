/**
 * Copyright (c) 2016 乐视云计算有限公司（lecloud.com）. All rights reserved
 */
package com.lynzabo.codegen.model;

import java.io.Serializable;

/**
 *  生成配置信息类 代码和模板文件使用的大本营
 * @author linzhanbo .
 * @since 2016年11月18日, 16:14 .
 * @version 1.0 .
 */
public class GenDTO implements Serializable {
    /**
     * 工程根路径
     */
    private String projectPath;
    /**
     * 生成包名
     */
    private String mpackage;
    /**
     * mapper.xml信息
     */
    private SqlMapperDTO sqlMapperDTO;
    /**
     * model信息
     */
    private ModelDTO modelDTO;
    /**
     * dao信息
     */
    private DaoDTO daoDTO;
    /**
     * service信息
     */
    private ServiceDTO serviceDTO;
    /**
     * service实现信息
     */
    private ServiceImplDTO serviceImplDTO;
    /**
     * controller信息
     */
    private ControllerDTO controllerDTO;
    /**
     * enumeration信息
     */
    private EnumerationDTO enumerationDTO;
    /**
     * interface信息
     */
    private InterfaceDTO interfaceDTO;
    /**
     * 模板渲染数据
     */
    private RenderDataDTO renderDataDTO;

    public String getProjectPath() {
        return projectPath;
    }

    public String getMpackage() {
        return mpackage;
    }

    public SqlMapperDTO getSqlMapperDTO() {
        return sqlMapperDTO;
    }

    public ModelDTO getModelDTO() {
        return modelDTO;
    }

    public DaoDTO getDaoDTO() {
        return daoDTO;
    }

    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    public ServiceImplDTO getServiceImplDTO() {
        return serviceImplDTO;
    }

    public ControllerDTO getControllerDTO() {
        return controllerDTO;
    }

    public EnumerationDTO getEnumerationDTO() {
        return enumerationDTO;
    }

    public InterfaceDTO getInterfaceDTO() {
        return interfaceDTO;
    }

    public RenderDataDTO getRenderDataDTO() {
        return renderDataDTO;
    }

    public static class GenDTOBuilder implements Serializable{
        private GenDTO genDTO = new GenDTO();
        public GenDTO build() {
            return genDTO;
        }
        public GenDTOBuilder setProjectPath(String projectPath) {
            genDTO.projectPath = projectPath;
            return this;
        }
        public GenDTOBuilder setMpackage(String mpackage) {
            genDTO.mpackage = mpackage;
            return this;
        }
        public GenDTOBuilder setSqlMapperDTO(SqlMapperDTO sqlMapperDTO) {
            genDTO.sqlMapperDTO = sqlMapperDTO;
            return this;
        }
        public GenDTOBuilder setModelDTO(ModelDTO modelDTO) {
            genDTO.modelDTO = modelDTO;
            return this;
        }
        public GenDTOBuilder setDaoDTO(DaoDTO daoDTO) {
            genDTO.daoDTO = daoDTO;
            return this;
        }
        public GenDTOBuilder setServiceDTO(ServiceDTO serviceDTO) {
            genDTO.serviceDTO = serviceDTO;
            return this;
        }
        public GenDTOBuilder setServiceImplDTO(ServiceImplDTO serviceImplDTO) {
            genDTO.serviceImplDTO = serviceImplDTO;
            return this;
        }
        public GenDTOBuilder setEnumerationDTO(EnumerationDTO enumerationDTO) {
            genDTO.enumerationDTO = enumerationDTO;
            return this;
        }
        public GenDTOBuilder setControllerDTO(ControllerDTO controllerDTO) {
            genDTO.controllerDTO = controllerDTO;
            return this;
        }
        public GenDTOBuilder setInterfaceDTO(InterfaceDTO interfaceDTO) {
            genDTO.interfaceDTO = interfaceDTO;
            return this;
        }
        public GenDTOBuilder setRenderDataDTO(RenderDataDTO renderDataDTO) {
            genDTO.renderDataDTO = renderDataDTO;
            return this;
        }
    }

}
