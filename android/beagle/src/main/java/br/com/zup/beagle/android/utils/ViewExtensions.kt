/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
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

package br.com.zup.beagle.android.utils

import android.view.View
import android.view.ViewGroup
import br.com.zup.beagle.R
import br.com.zup.beagle.android.context.ContextBinding
import br.com.zup.beagle.android.context.ContextData
import br.com.zup.beagle.android.context.normalize

internal fun View.findParentContextWithId(contextId: String): View? {
    var parentView: View? = this.getParentContextData()
    do {
        val context = parentView?.getContextBinding()
        if (context != null && context.context.id == contextId) {
            return parentView
        }
        parentView = (parentView?.parent as? ViewGroup)?.getParentContextData()
    } while (parentView != null)

    return null
}

internal fun View.getAllParentContexts(): MutableList<ContextBinding> {
    val contexts = mutableListOf<ContextBinding>()

    var parentView: View? = getParentContextData()
    do {
        val contextBinding = parentView?.getContextBinding()
        if (contextBinding != null) {
            contexts.add(contextBinding)
        }
        parentView = (parentView?.parent as? ViewGroup)?.getParentContextData()
    } while (parentView != null)

    return contexts
}

internal fun View.getParentContextData(): View? {
    if (this.getContextData() != null) {
        return this
    }

    var parentView: View? = this.parent as? ViewGroup
    do {
        if (parentView?.getContextData() != null) {
            break
        }
        parentView = parentView?.parent as? ViewGroup
    } while (parentView != null)

    return parentView
}

internal fun View.setContextData(context: ContextData) {
    val normalizedContext = context.normalize()
    val contextBinding = getContextBinding()
    if (contextBinding != null) {
        setContextBinding(ContextBinding(normalizedContext, contextBinding.bindings))
    } else {
        setContextBinding(ContextBinding(normalizedContext))
    }
}

internal fun View.getContextData(): ContextData? {
    return getContextBinding()?.context
}

internal fun View.setContextBinding(contextBinding: ContextBinding) {
    setTag(R.id.beagle_context_view, contextBinding)
}

internal fun View.getContextBinding(): ContextBinding? {
    return getTag(R.id.beagle_context_view) as? ContextBinding
}

internal fun View.setIsAutoGenerateIdEnabled(autoGenerateId: Boolean) {
    setTag(R.id.beagle_auto_generate_id_enabled, autoGenerateId)
}

internal fun View.isAutoGenerateIdEnabled(): Boolean {
    return getTag(R.id.beagle_auto_generate_id_enabled) as? Boolean ?: true
}

internal fun View.setIsInitiableComponent(isInitiableComponent: Boolean) {
    setTag(R.id.initiable_component, isInitiableComponent)
}

internal fun View.isInitiableComponent(): Boolean {
    return getTag(R.id.initiable_component) as? Boolean ?: false
}
