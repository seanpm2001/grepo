/*
 * Copyright 2011 Grepo Committers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.grepo.query.jpa.repository.custom;

import org.codehaus.grepo.core.context.GrepoHsqlTestContextLoaderWithDefLoc;
import org.codehaus.grepo.query.jpa.AbstractJpaRepositoryTest;
import org.codehaus.grepo.query.jpa.TestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author dguggi
 */
@ContextConfiguration(loader = GrepoHsqlTestContextLoaderWithDefLoc.class)
public class CustomRepository3Test extends AbstractJpaRepositoryTest {

    /** The custom test repository3. */
    @Autowired
    private CustomRepository3 customRepository3; // NOPMD

    /**
     * Demonstrates the use of a custom repository implementation for (grepo) one repository instance. In this example
     * the {@code customRepository2} will have a method {@code doSomethingSpecial} as defined by
     * {@link CustomRepository2} and {@link CustomRepository2Impl}.
     */
    @Test
    public void testDoSomethingSpecial() {
        Assert.assertNull(customRepository3.doSomethingSpecial(-1L));

        TestEntity entity = new TestEntity("username", 1, "firstname");
        saveFlush(entity);
        Assert.assertNotNull(customRepository3.doSomethingSpecial(entity.getId()));
    }
}
