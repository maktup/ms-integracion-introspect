package com.tdp.ms.introspect.expose;

import com.tdp.ms.introspect.business.IntrospectService;
import com.tdp.ms.introspect.model.IntrospectRequest;
import com.tdp.ms.introspect.model.IntrospectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class: IntrospectController. <br/>
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
@Slf4j
@RestController
@RequestMapping("/introspect/v1/greeting")
@RequiredArgsConstructor
public class IntrospectController {

    private final IntrospectService introspectService;

    @GetMapping
    public Mono<IntrospectResponse> indexGet() {
        return Mono.justOrEmpty(this.introspectService.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IntrospectResponse> indexPost(@RequestBody IntrospectRequest request) {
        log.info("Body: {}" , request.getName());
        return Mono.justOrEmpty(this.introspectService.put(request.getName()));
    
    }

}
