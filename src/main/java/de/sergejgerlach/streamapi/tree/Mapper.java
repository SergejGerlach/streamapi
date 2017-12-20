package de.sergejgerlach.streamapi.tree;

import java.util.List;

public class Mapper {

    public static TreeNode mapEntity(TreeEntity entity) {
        if (entity == null) throw new IllegalArgumentException("entity is null");

        return new TreeNode(entity.getId(), entity.getParentId(), entity.getName());
    }

    public static TreeNode mapEntities(List<TreeEntity> entities) {
        if (entities == null || entities.isEmpty()) throw new IllegalArgumentException("entities is null or empty");

        TreeEntity entity = entities.get(0);
        return new TreeNode(entity.getId(), entity.getParentId(), entity.getName());
    }
}
