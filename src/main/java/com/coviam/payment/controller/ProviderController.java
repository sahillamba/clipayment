package com.coviam.payment.controller;

import com.coviam.payment.dto.ProviderConfigDTO;
import com.coviam.payment.entity.ProviderConfig;
import com.coviam.payment.services.ProviderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by avinashkumar on 06/02/2018 AD.
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @RequestMapping(
            value = "/createProvider",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createProvider(@RequestBody ProviderConfigDTO providerConfigDTO) {

        ProviderConfig providerConfig = new ProviderConfig();
        BeanUtils.copyProperties(providerConfigDTO, providerConfig);
        ProviderConfig providerCreated = providerService.save(providerConfig);

        return new ResponseEntity<String>(String.valueOf(providerCreated.getId()), HttpStatus.CREATED);
    }


    @RequestMapping(
            value = "/get/{providerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getProvider(@PathVariable("providerId") String providerId) {
        ProviderConfig providerConfig = providerService.findOne(providerId);
        ProviderConfigDTO providerConfigDTO = new ProviderConfigDTO();

        if(providerConfig == null){
            return new ResponseEntity<String>("", HttpStatus.OK);
        }

        BeanUtils.copyProperties(providerConfig,providerConfigDTO);
        return new ResponseEntity<ProviderConfigDTO>(providerConfigDTO, HttpStatus.OK);
    }

}
