/* This file is part of Green.
 *
 * Copyright (C) 2005 The Research Foundation of State University of New York
 * All Rights Under Copyright Reserved, The Research Foundation of S.U.N.Y.
 * 
 * Green is free software, licensed under the terms of the Eclipse
 * Public License, version 1.0.  The license is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package edu.buffalo.cse.green.relationship.generalization;

import java.util.List;

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.Type;

import edu.buffalo.cse.green.relationships.RelationshipRemover;
import edu.buffalo.cse.green.relationships.DeclarationInfoProvider;

/**
 * @see edu.buffalo.cse.green.relationship.RelationshipRemover
 * 
 * @author bcmartin
 */
public class GeneralizationRemover extends RelationshipRemover {
	/**
	 * @see edu.buffalo.cse.green.relationships.RelationshipVisitor#process(org.eclipse.jdt.core.dom.TypeDeclaration)
	 */
	public boolean process(DeclarationInfoProvider node) {
		if (node.isInterface()) {
			IType elementToDelete = getTargetType();
			List<Type> superInterfaceTypes = node.getSuperInterfaceTypes();

			for (Type type : superInterfaceTypes) {
				// check for match on removal
				if (getType(type).equals(elementToDelete)) {
					type.delete();
					break;
				}
			}
		} else {
			node.setSuperclassType(null);
		}

		return true;
	}

	/**
	 * @see edu.buffalo.cse.green.relationships.RelationshipRemover#finish()
	 */
	protected void finish() {
		// removal complete
	}

	/**
	 * @see edu.buffalo.cse.green.relationships.RelationshipRemover#init()
	 */
	protected void init() {
		// no action necessary
	}
}