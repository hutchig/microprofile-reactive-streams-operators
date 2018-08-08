/*******************************************************************************
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package org.eclipse.microprofile.reactive.streams.tck.spi;

import org.eclipse.microprofile.reactive.streams.ReactiveStreams;
import org.reactivestreams.Processor;

import java.util.Collections;
import java.util.List;

/**
 * Verification for an empty processor, ie, the processor returned from ReactiveStreams.builder().buildRs().
 */
public class EmptyProcessorVerification extends AbstractStageVerification {

    public EmptyProcessorVerification(ReactiveStreamsSpiVerification.VerificationDeps deps) {
        super(deps);
    }

    @Override
    List<Object> reactiveStreamsTckVerifiers() {
        return Collections.singletonList(new ProcessorVerification());
    }

    public class ProcessorVerification extends StageProcessorVerification<Integer> {
        @Override
        public Processor<Integer, Integer> createIdentityProcessor(int bufferSize) {
            return ReactiveStreams.<Integer>builder().buildRs(getEngine());
        }

        @Override
        public Integer createElement(int element) {
            return element;
        }
    }
}