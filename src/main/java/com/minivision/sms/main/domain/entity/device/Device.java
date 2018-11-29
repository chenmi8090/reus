package com.minivision.sms.main.domain.entity.device;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_device")
public class Device {
    /**
     * 设备id
     */
    @Id
    @Column(name = "device_id")
    private String deviceId;

    /**
     * 应用key
     */
    @Column(name = "app_key")
    private String appKey;

    /**
     * 设备sn
     */
    @Column(name = "device_sn")
    private String deviceSn;

    /**
     * 设备名称
     */
    @Column(name = "device_name")
    private String deviceName;

    /**
     * 设备类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * IP地址
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * IP端口
     */
    @Column(name = "ip_port")
    private Integer ipPort;

    /**
     * MAC地址
     */
    @Column(name = "mac_address")
    private String macAddress;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 应用平台设备ID
     */
    @Column(name = "iot_device_id")
    private Long iotDeviceId;

    /**
     * 是否删除0否1是
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人ID
     */
    private String modifier;

    /**
     * 修改人
     */
    @Column(name = "modifier_id")
    private String modifierId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本号
     */
    private String version;

    /**
     * 0:成功 1:失败 2:处理中
     */
    @Column(name = "sync_status")
    private Integer syncStatus;

    /**
     * 获取设备id
     *
     * @return device_id - 设备id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     *
     * @param deviceId 设备id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取应用key
     *
     * @return app_key - 应用key
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 设置应用key
     *
     * @param appKey 应用key
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * 获取设备sn
     *
     * @return device_sn - 设备sn
     */
    public String getDeviceSn() {
        return deviceSn;
    }

    /**
     * 设置设备sn
     *
     * @param deviceSn 设备sn
     */
    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    /**
     * 获取设备名称
     *
     * @return device_name - 设备名称
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置设备名称
     *
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取设备类型
     *
     * @return device_type - 设备类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置设备类型
     *
     * @param deviceType 设备类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * 获取IP地址
     *
     * @return ip_address - IP地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置IP地址
     *
     * @param ipAddress IP地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 获取IP端口
     *
     * @return ip_port - IP端口
     */
    public Integer getIpPort() {
        return ipPort;
    }

    /**
     * 设置IP端口
     *
     * @param ipPort IP端口
     */
    public void setIpPort(Integer ipPort) {
        this.ipPort = ipPort;
    }

    /**
     * 获取MAC地址
     *
     * @return mac_address - MAC地址
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * 设置MAC地址
     *
     * @param macAddress MAC地址
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取应用平台设备ID
     *
     * @return iot_device_id - 应用平台设备ID
     */
    public Long getIotDeviceId() {
        return iotDeviceId;
    }

    /**
     * 设置应用平台设备ID
     *
     * @param iotDeviceId 应用平台设备ID
     */
    public void setIotDeviceId(Long iotDeviceId) {
        this.iotDeviceId = iotDeviceId;
    }

    /**
     * 获取是否删除0否1是
     *
     * @return is_delete - 是否删除0否1是
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除0否1是
     *
     * @param isDelete 是否删除0否1是
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建人ID
     *
     * @return creator_id - 创建人ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人ID
     *
     * @param creatorId 创建人ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人ID
     *
     * @return modifier - 修改人ID
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人ID
     *
     * @param modifier 修改人ID
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改人
     *
     * @return modifier_id - 修改人
     */
    public String getModifierId() {
        return modifierId;
    }

    /**
     * 设置修改人
     *
     * @param modifierId 修改人
     */
    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取0:成功 1:失败 2:处理中
     *
     * @return sync_status - 0:成功 1:失败 2:处理中
     */
    public Integer getSyncStatus() {
        return syncStatus;
    }

    /**
     * 设置0:成功 1:失败 2:处理中
     *
     * @param syncStatus 0:成功 1:失败 2:处理中
     */
    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}