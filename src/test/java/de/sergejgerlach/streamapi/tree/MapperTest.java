package de.sergejgerlach.streamapi.tree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MapperTest {

    @Test
    public void givenNull_when_map_throwsException() {
        // given / when / then
        assertThatThrownBy(() -> Mapper.map(null)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void givenTreeEntity_when_map_returnsMappedTreeNode() {
        // given
        TreeEntity entity = new TreeEntity("1.1", "1", "node-1.1");

        // when
        TreeNode sut = Mapper.map(entity);

        // then
        assertThat(sut).extracting("id", "parentId", "name", "children")
                .contains("1.1", "1", "node-1.1", null);
    }
}
