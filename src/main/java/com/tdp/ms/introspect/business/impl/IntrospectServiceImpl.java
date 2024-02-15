package com.tdp.ms.introspect.business.impl;

import com.tdp.ms.introspect.business.IntrospectService;
import com.tdp.ms.introspect.model.IntrospectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Class: IntrospectServiceImpl. <br/>
 * <b>Copyright</b>: &copy; 2019 Telef&oacute;nica del Per&uacute;<br/>
 * <b>Company</b>: Telef&oacute;nica del Per&uacute;<br/>
 *
 * @author Telef&oacute;nica del Per&uacute; (TDP) <br/>
 *         <u>Service Provider</u>: Everis Per&uacute; SAC (EVE) <br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Developer name</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>YYYY-MM-DD Creaci&oacute;n del proyecto.</li>
 *         </ul>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class IntrospectServiceImpl implements IntrospectService {

    @Override
    public IntrospectResponse get() {
        return new IntrospectResponse("Hello world!");
    }

    @Override
    public IntrospectResponse put(String name) {
        return new IntrospectResponse(name + " created!");
    }

}
