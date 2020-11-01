package com.jumper.pojo;

public class Role {
    private int roleID;
    private String roleName;
    private String permissions;

    public Role() {
    }

    public Role(int roleID, String roleName, String permissions) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
