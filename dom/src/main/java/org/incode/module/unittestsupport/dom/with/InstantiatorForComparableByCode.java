/**
 * or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.incode.module.unittestsupport.dom.with;

import org.apache.isis.core.unittestsupport.bidir.Instantiator;

import org.incode.module.base.dom.with.WithCodeComparable;

public class InstantiatorForComparableByCode implements Instantiator {

    public final Class<? extends WithCodeComparable<?>> cls;
    private int i;
    
    public InstantiatorForComparableByCode(Class<? extends WithCodeComparable<?>> cls) {
        this.cls = cls;
    }

    @Override
    public Object instantiate() {
        WithCodeComparable<?> newInstance;
        try {
            newInstance = cls.newInstance();
            newInstance.setCode(""+(++i));
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}