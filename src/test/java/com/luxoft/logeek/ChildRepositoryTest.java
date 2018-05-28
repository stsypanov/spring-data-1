package com.luxoft.logeek;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.entity.Child;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@DatabaseSetup("/ChildRepositoryTest.xml")
public class ChildRepositoryTest extends TestBase {

    @Test
    public void findByParentIds() {
        List<Long> ids = Arrays.asList(1L);
        List<Child> children = childRepository.findByParentIds(ids);

        assertThat(4, is(children.size()));
    }

    @Test
    public void findChildByParent_Name() {
        List<String> names = Arrays.asList("папа", "папа", "папа");
        List<Child> children = childRepository.findChildByParentName(names);

        assertThat(4, is(children.size()));
    }
}
