// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package com.nt.proxy;

import com.sun.xml.rpc.server.http.MessageContextProperties;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.encoding.literal.*;
import com.sun.xml.rpc.soap.streaming.*;
import com.sun.xml.rpc.soap.message.*;
import com.sun.xml.rpc.soap.SOAPVersion;
import com.sun.xml.rpc.soap.SOAPEncodingConstants;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.lang.reflect.*;
import java.lang.Class;
import com.sun.xml.rpc.client.SenderException;
import com.sun.xml.rpc.client.*;
import com.sun.xml.rpc.client.http.*;
import javax.xml.rpc.handler.*;
import javax.xml.rpc.JAXRPCException;
import javax.xml.rpc.soap.SOAPFaultException;

public class IHelloService_Stub
    extends com.sun.xml.rpc.client.StubBase
    implements com.nt.proxy.IHelloService {
    
    
    
    /*
     *  public constructor
     */
    public IHelloService_Stub(HandlerChain handlerChain) {
        super(handlerChain);
        _setProperty(ENDPOINT_ADDRESS_PROPERTY, "http://localhost:4343/JAX-RPC_SI_HelloExample_ContractLast/hello");
    }
    
    
    /*
     *  implementation of wish
     */
    public java.lang.String wish(java.lang.String string_1)
        throws java.rmi.RemoteException {
        
        try {
            
            StreamingSenderState _state = _start(_handlerChain);
            
            InternalSOAPMessage _request = _state.getRequest();
            _request.setOperationCode(wish_OPCODE);
            com.nt.proxy.IHelloService_wish_RequestStruct _myIHelloService_wish_RequestStruct =
                new com.nt.proxy.IHelloService_wish_RequestStruct();
            
            _myIHelloService_wish_RequestStruct.setString_1(string_1);
            
            SOAPBlockInfo _bodyBlock = new SOAPBlockInfo(ns1_wish_wish_QNAME);
            _bodyBlock.setValue(_myIHelloService_wish_RequestStruct);
            _bodyBlock.setSerializer(ns1_myIHelloService_wish_RequestStruct_SOAPSerializer);
            _request.setBody(_bodyBlock);
            
            _state.getMessageContext().setProperty(HttpClientTransport.HTTP_SOAPACTION_PROPERTY, "");
            
            _send((java.lang.String) _getProperty(ENDPOINT_ADDRESS_PROPERTY), _state);
            
            com.nt.proxy.IHelloService_wish_ResponseStruct _myIHelloService_wish_ResponseStruct = null;
            Object _responseObj = _state.getResponse().getBody().getValue();
            if (_responseObj instanceof SOAPDeserializationState) {
                _myIHelloService_wish_ResponseStruct =
                    (com.nt.proxy.IHelloService_wish_ResponseStruct)((SOAPDeserializationState)_responseObj).getInstance();
            } else {
                _myIHelloService_wish_ResponseStruct =
                    (com.nt.proxy.IHelloService_wish_ResponseStruct)_responseObj;
            }
            
            return _myIHelloService_wish_ResponseStruct.getResult();
        } catch (RemoteException e) {
            // let this one through unchanged
            throw e;
        } catch (JAXRPCException e) {
            throw new RemoteException(e.getMessage(), e);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException)e;
            } else {
                throw new RemoteException(e.getMessage(), e);
            }
        }
    }
    
    
    /*
     *  this method deserializes the request/response structure in the body
     */
    protected void _readFirstBodyElement(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState  state) throws Exception {
        int opcode = state.getRequest().getOperationCode();
        switch (opcode) {
            case wish_OPCODE:
                _deserialize_wish(bodyReader, deserializationContext, state);
                break;
            default:
                throw new SenderException("sender.response.unrecognizedOperation", java.lang.Integer.toString(opcode));
        }
    }
    
    
    
    /*
     * This method deserializes the body of the wish operation.
     */
    private void _deserialize_wish(XMLReader bodyReader, SOAPDeserializationContext deserializationContext, StreamingSenderState state) throws Exception {
        java.lang.Object myIHelloService_wish_ResponseStructObj =
            ns1_myIHelloService_wish_ResponseStruct_SOAPSerializer.deserialize(ns1_wish_wishResponse_QNAME,
                bodyReader, deserializationContext);
        
        SOAPBlockInfo bodyBlock = new SOAPBlockInfo(ns1_wish_wishResponse_QNAME);
        bodyBlock.setValue(myIHelloService_wish_ResponseStructObj);
        state.getResponse().setBody(bodyBlock);
    }
    
    
    
    public java.lang.String _getDefaultEnvelopeEncodingStyle() {
        return SOAPNamespaceConstants.ENCODING;
    }
    
    public java.lang.String _getImplicitEnvelopeEncodingStyle() {
        return "";
    }
    
    public java.lang.String _getEncodingStyle() {
        return SOAPNamespaceConstants.ENCODING;
    }
    
    public void _setEncodingStyle(java.lang.String encodingStyle) {
        throw new UnsupportedOperationException("cannot set encoding style");
    }
    
    
    
    
    
    /*
     * This method returns an array containing (prefix, nsURI) pairs.
     */
    protected java.lang.String[] _getNamespaceDeclarations() {
        return myNamespace_declarations;
    }
    
    /*
     * This method returns an array containing the names of the headers we understand.
     */
    public javax.xml.namespace.QName[] _getUnderstoodHeaders() {
        return understoodHeaderNames;
    }
    
    
    protected void _preHandlingHook(StreamingSenderState state) throws Exception {
        super._preHandlingHook(state);
    }
    
    
    protected boolean _preRequestSendingHook(StreamingSenderState state) throws Exception {
        boolean bool = false;
        bool = super._preRequestSendingHook(state);
        return bool;
    }
    
    public void _initialize(InternalTypeMappingRegistry registry) throws Exception {
        super._initialize(registry);
        ns1_myIHelloService_wish_RequestStruct_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, com.nt.proxy.IHelloService_wish_RequestStruct.class, ns1_wish_TYPE_QNAME);
        ns1_myIHelloService_wish_ResponseStruct_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, com.nt.proxy.IHelloService_wish_ResponseStruct.class, ns1_wishResponse_TYPE_QNAME);
    }
    
    private static final javax.xml.namespace.QName _portName = new QName("http://service.hello.com/wsdl", "IHelloServicePort");
    private static final int wish_OPCODE = 0;
    private static final javax.xml.namespace.QName ns1_wish_wish_QNAME = new QName("http://service.hello.com/wsdl", "wish");
    private static final javax.xml.namespace.QName ns1_wish_TYPE_QNAME = new QName("http://service.hello.com/wsdl", "wish");
    private CombinedSerializer ns1_myIHelloService_wish_RequestStruct_SOAPSerializer;
    private static final javax.xml.namespace.QName ns1_wish_wishResponse_QNAME = new QName("http://service.hello.com/wsdl", "wishResponse");
    private static final javax.xml.namespace.QName ns1_wishResponse_TYPE_QNAME = new QName("http://service.hello.com/wsdl", "wishResponse");
    private CombinedSerializer ns1_myIHelloService_wish_ResponseStruct_SOAPSerializer;
    private static final java.lang.String[] myNamespace_declarations =
                                        new java.lang.String[] {
                                            "ns0", "http://service.hello.com/wsdl"
                                        };
    
    private static final QName[] understoodHeaderNames = new QName[] {  };
}