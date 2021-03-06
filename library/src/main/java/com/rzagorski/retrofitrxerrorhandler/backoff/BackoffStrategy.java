/*
 * Copyright (C) 2016 Robert Zagórski.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rzagorski.retrofitrxerrorhandler.backoff;

import rx.Observable;
import rx.functions.Func1;

/**
 * The base interface for all backoff strategies.
 * <p>
 * Created by Robert Zagórski on 2016-09-28.
 */
public interface BackoffStrategy extends Func1<Observable<? extends Throwable>, Observable<?>> {

    /**
     * Defines, whether the specifies throwable should be handled by this {@link BackoffStrategy}
     *
     * @param throwable error to be considered
     * @return whether error is met
     */
    boolean isApplicable(Throwable throwable);

    /**
     * Enabling logging feature for this {@link BackoffStrategy}
     *
     * @param logging whether logging should be enabled
     */
    void setLoggingEnabled(boolean logging);

    <T> Observable<T> getBackupObservable();
}
