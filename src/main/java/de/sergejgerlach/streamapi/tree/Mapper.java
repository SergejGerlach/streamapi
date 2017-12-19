package de.sergejgerlach.streamapi.tree;

public class Mapper {

    public static TreeNode map(TreeEntity entity) {
        if (entity == null) throw new IllegalArgumentException("entity is null");

        return new TreeNode(entity.getId(), entity.getParentId(), entity.getName());
    }
}
