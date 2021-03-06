/*
 * Copyright © 2016 Tinkoff Bank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.tinkoff.acquiring.sdk.requests;

/**
 * @author Mikhail Artemyev
 */
final public class FinishAuthorizeRequestBuilder extends AcquiringRequestBuilder<FinishAuthorizeRequest> {

    private FinishAuthorizeRequest request = new FinishAuthorizeRequest();

    public FinishAuthorizeRequestBuilder(final String password, final String terminalKey) {
        super(password, terminalKey);
    }


    public FinishAuthorizeRequestBuilder setPaymentId(final Long value) {
        request.setPaymentId(value);
        return this;
    }

    public FinishAuthorizeRequestBuilder setSendEmail(final boolean value) {
        request.setSendEmail(value);
        return this;
    }

    public FinishAuthorizeRequestBuilder setCardData(final String value) {
        request.setCardData(value);
        return this;
    }

    public FinishAuthorizeRequestBuilder setEmail(final String email) {
        request.setEmail(email);
        return this;
    }

    @Override
    protected void validate() {
        validateZeroOrPositive(request.getPaymentId(), "Payment ID");
        if (request.getCardId() == null) {
            validateNonEmpty(request.getCardData(), "Card data");
        } else {
            validateNonEmpty(request.getCardId(), "CardId");
            validateNonEmpty(request.getCvv(), "CVV");
        }
    }

    @Override
    protected FinishAuthorizeRequest getRequest() {
        return request;
    }
}
