package de.sergejgerlach.streamapi.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.emptyList;
import static org.assertj.core.api.Assertions.*;


public class MapperTest {

    @Test
    public void givenNull_when_mapEntity_throwsException() {
        // given / when / then
        assertThatThrownBy(() -> Mapper.mapEntity(null)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void givenTreeEntity_when_mapEntity_returnsMappedTreeNode() {
        // given
        TreeEntity entity = new TreeEntity("1.1", "1", "node-1.1");

        // when
        TreeNode sut = Mapper.mapEntity(entity);

        // then
        assertThat(sut).extracting("id", "parentId", "name", "children")
                .contains("1.1", "1", "node-1.1", null);
    }

    @Test
    public void givenNull_when_mapEntities_throwsException() {
        // given / when / then
        assertThatThrownBy(() -> Mapper.mapEntities(null)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void givenEmpty_when_mapEntities_throwsException() {
        // given / when / then
        assertThatThrownBy(() -> Mapper.mapEntities(emptyList())).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void givenListOfOneTreeEntity_when_mapEntities_returnsMappedTreeNode() {
        // given
        List<TreeEntity> entities = new ArrayList<>();
        entities.add(new TreeEntity("1.1", "1", "node-1.1"));

        // when
        TreeNode sut = Mapper.mapEntities(entities);

        // then
        assertThat(sut).extracting("id", "parentId", "name", "children")
                .contains("1.1", "1", "node-1.1", null);
    }

    @Test
    public void givenListOfManyTreeEntity_when_mapEntities_returnsMappedTreeNode() {
        // given
        List<TreeEntity> entities = new ArrayList<>();
        entities.add(new TreeEntity("1.1", "1", "node-1.1"));
        entities.add(new TreeEntity("1.2", "1", "node-1.1"));
        entities.add(new TreeEntity("1.3", "1", "node-1.1"));
        entities.add(new TreeEntity("1.4", "1", "node-1.1"));
        entities.add(new TreeEntity("1.5", "1", "node-1.1"));

        // when
        TreeNode sut = Mapper.mapEntities(entities);

        // then
        assertThat(sut).extracting("id", "parentId", "name", "children")
                .contains("1.1", "1", "node-1.1", null);
    }
}
