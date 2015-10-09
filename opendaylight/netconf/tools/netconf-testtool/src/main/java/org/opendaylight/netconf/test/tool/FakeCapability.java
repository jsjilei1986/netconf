/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netconf.test.tool;

import com.google.common.base.Optional;
import org.opendaylight.controller.config.util.capability.BasicCapability;
import org.opendaylight.controller.config.util.capability.YangModuleCapability;

/**
 * Can be passed instead of YangModuleCapability when building capabilities
 * in NetconfDeviceSimulator when testing various schema resolution related exceptions.
 *
 */
public class FakeCapability extends BasicCapability {
    private final YangModuleCapability moduleCapability;

    public FakeCapability(final YangModuleCapability moduleCapability) {
        super(moduleCapability.getCapabilityUri());
        this.moduleCapability = moduleCapability;
    }

    @Override
    public Optional<String> getModuleNamespace() {
        return moduleCapability.getModuleNamespace();
    }

    @Override
    public Optional<String> getModuleName() {
        return moduleCapability.getModuleName();
    }

    @Override
    public Optional<String> getRevision() {
        return moduleCapability.getRevision();
    }

    /**
     l*
     * @return empty schema source to trigger schema resolution exception.
     */
    @Override
    public Optional<String> getCapabilitySchema() {
        return Optional.absent();
    }
}
