/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.util

import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrTypeOperatorCall
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid
import org.jetbrains.kotlin.ir.visitors.acceptVoid

fun IrElement.adjustTypes(typeRemapper: TypeRemapper) {
    acceptVoid(AdjustTypes(typeRemapper))
}

class AdjustTypes(private val typeRemapper: TypeRemapper) : IrElementVisitorVoid {

    override fun visitElement(element: IrElement) {
        element.acceptChildrenVoid(this)
    }

    override fun visitExpression(expression: IrExpression) {
        expression.type = typeRemapper.remapType(expression.type)
        super.visitExpression(expression)
    }

    override fun visitValueParameter(declaration: IrValueParameter) {
        declaration.type = typeRemapper.remapType(declaration.type)
        super.visitValueParameter(declaration)
    }

    override fun visitVariable(declaration: IrVariable) {
        declaration.type = typeRemapper.remapType(declaration.type)
        super.visitVariable(declaration)
    }

    override fun visitFunction(declaration: IrFunction) {
        declaration.returnType = typeRemapper.remapType(declaration.returnType)
        super.visitFunction(declaration)
    }

    override fun visitField(declaration: IrField) {
        declaration.type = typeRemapper.remapType(declaration.type)
        super.visitField(declaration)
    }

    override fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty) {
        declaration.type = typeRemapper.remapType(declaration.type)
        super.visitLocalDelegatedProperty(declaration)
    }

    override fun visitTypeAlias(declaration: IrTypeAlias) {
        declaration.expandedType = typeRemapper.remapType(declaration.expandedType)
        super.visitTypeAlias(declaration)
    }

    override fun visitTypeOperator(expression: IrTypeOperatorCall) {
        expression.typeOperand = typeRemapper.remapType(expression.typeOperand)
        super.visitTypeOperator(expression)
    }

}