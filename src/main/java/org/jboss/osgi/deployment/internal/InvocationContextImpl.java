/*
 * #%L
 * JBossOSGi Deployment
 * %%
 * Copyright (C) 2010 - 2012 JBoss by Red Hat
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.osgi.deployment.internal;

import static org.jboss.osgi.deployment.internal.DeploymentMessages.MESSAGES;

import java.util.Collection;

import org.jboss.osgi.deployment.interceptor.InvocationContext;
import org.jboss.osgi.spi.Attachments;
import org.jboss.osgi.vfs.VirtualFile;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The context passed between Interceptors
 * 
 * @author thomas.diesler@jboss.com
 * @since 27-May-2009
 */
public class InvocationContextImpl implements InvocationContext {
    private Attachments attachments;
    private BundleContext systemContext;
    private VirtualFile root;
    private Bundle bundle;

    public InvocationContextImpl(BundleContext systemContext, Bundle bundle, VirtualFile root, Attachments attachments) {
        if (systemContext == null)
            throw MESSAGES.illegalArgumentNull("context");
        if (bundle == null)
            throw MESSAGES.illegalArgumentNull("bundle");
        if (attachments == null)
            throw MESSAGES.illegalArgumentNull("attachments");

        this.systemContext = systemContext;
        this.root = root;
        this.bundle = bundle;
        this.attachments = attachments;
    }

    public BundleContext getSystemContext() {
        return systemContext;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public VirtualFile getRoot() {
        return root;
    }

    public <T> T addAttachment(Class<T> clazz, T value) {
        return attachments.addAttachment(clazz, value);
    }

    public <T> T addAttachment(String name, T value, Class<T> clazz) {
        return attachments.addAttachment(name, value, clazz);
    }

    public Object addAttachment(String name, Object value) {
        return attachments.addAttachment(name, value);
    }

    public <T> T getAttachment(String name, Class<T> clazz) {
        return attachments.getAttachment(name, clazz);
    }

    public <T> T getAttachment(Class<T> clazz) {
        return attachments.getAttachment(clazz);
    }

    public Object getAttachment(String name) {
        return attachments.getAttachment(name);
    }

    public Collection<Key> getAttachmentKeys() {
        return attachments.getAttachmentKeys();
    }

    public <T> T removeAttachment(Class<T> clazz, String name) {
        return attachments.removeAttachment(clazz, name);
    }

    public <T> T removeAttachment(Class<T> clazz) {
        return attachments.removeAttachment(clazz);
    }

    public Object removeAttachment(String name) {
        return attachments.removeAttachment(name);
    }
}