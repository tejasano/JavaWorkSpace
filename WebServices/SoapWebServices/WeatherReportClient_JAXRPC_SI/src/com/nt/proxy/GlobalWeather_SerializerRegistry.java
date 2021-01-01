// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package com.nt.proxy;

import com.sun.xml.rpc.client.BasicService;
import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.*;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.soap.SOAPVersion;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.rpc.*;
import javax.xml.rpc.encoding.*;
import javax.xml.namespace.QName;

public class GlobalWeather_SerializerRegistry implements SerializerConstants {
    public GlobalWeather_SerializerRegistry() {
    }
    
    public TypeMappingRegistry getRegistry() {
        
        TypeMappingRegistry registry = BasicService.createStandardTypeMappingRegistry();
        TypeMapping mapping12 = registry.getTypeMapping(SOAP12Constants.NS_SOAP_ENCODING);
        TypeMapping mapping = registry.getTypeMapping(SOAPConstants.NS_SOAP_ENCODING);
        TypeMapping mapping2 = registry.getTypeMapping("");
        {
            QName type = new QName("http://www.webserviceX.NET", "GetWeather");
            CombinedSerializer serializer = new com.nt.proxy.GetWeather_LiteralSerializer(type, "", DONT_ENCODE_TYPE);
            registerSerializer(mapping2,com.nt.proxy.GetWeather.class, type, serializer);
        }
        {
            QName type = new QName("http://www.webserviceX.NET", "GetWeatherResponse");
            CombinedSerializer serializer = new com.nt.proxy.GetWeatherResponse_LiteralSerializer(type, "", DONT_ENCODE_TYPE);
            registerSerializer(mapping2,com.nt.proxy.GetWeatherResponse.class, type, serializer);
        }
        {
            QName type = new QName("http://www.webserviceX.NET", "GetCitiesByCountry");
            CombinedSerializer serializer = new com.nt.proxy.GetCitiesByCountry_LiteralSerializer(type, "", DONT_ENCODE_TYPE);
            registerSerializer(mapping2,com.nt.proxy.GetCitiesByCountry.class, type, serializer);
        }
        {
            QName type = new QName("http://www.webserviceX.NET", "GetCitiesByCountryResponse");
            CombinedSerializer serializer = new com.nt.proxy.GetCitiesByCountryResponse_LiteralSerializer(type, "", DONT_ENCODE_TYPE);
            registerSerializer(mapping2,com.nt.proxy.GetCitiesByCountryResponse.class, type, serializer);
        }
        return registry;
    }
    
    private static void registerSerializer(TypeMapping mapping, java.lang.Class javaType, javax.xml.namespace.QName xmlType,
        Serializer ser) {
        mapping.register(javaType, xmlType, new SingletonSerializerFactory(ser),
            new SingletonDeserializerFactory((Deserializer)ser));
    }
    
}
