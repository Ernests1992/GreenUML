/* This file is part of Green.
 *
 * Copyright (C) 2005 The Research Foundation of State University of New York
 * All Rights Under Copyright Reserved, The Research Foundation of S.U.N.Y.
 * 
 * Green is free software, licensed under the terms of the Eclipse
 * Public License, version 1.0.  The license is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package edu.buffalo.cse.green.editor.action;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.actions.ActionFactory;

import edu.buffalo.cse.green.editor.DiagramEditor;

/**
 * Refreshes the editor
 * 
 * @author bcmartin
 * @author rjtruban
 */
public class RefreshAction extends ContextAction {
	
	public RefreshAction(){
		super(null);
		setAccelerator(EDITOR_REFRESH_ACTION);
	}
	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#getLabel()
	 */
	public String getLabel() {
		return "Refresh Editor";
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#doRun()
	 */
	protected void doRun() throws JavaModelException {
		DiagramEditor.getActiveEditor().refresh();
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#getSupportedModels()
	 */
	protected int getSupportedModels() {
		return CM_ALL;
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#isAvailableForBinary()
	 */
	public boolean isAvailableForBinary() {
		return true;
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#getPath()
	 */
	public Submenu getPath() {
		return Submenu.None;
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#getGlobalActionHandler()
	 */
	public ActionFactory getGlobalActionHandler() {
		return ActionFactory.REFRESH;
	}

	/**
	 * @see edu.buffalo.cse.green.editor.action.ContextAction#isEnabled()
	 */
	public boolean isEnabled() {
		return true;
	}
}
