
package org.rasea.agent.seam.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Maintenance", targetNamespace = "http://rasea.org/ws/Maintenance")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Maintenance {


    /**
     * 
     * @param addApplication
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.AddApplicationResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "addApplicationResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addApplicationResponse")
    public AddApplicationResponse addApplication(
        @WebParam(name = "addApplication", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addApplication")
        AddApplication addApplication,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param addOperation
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.AddOperationResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "addOperationResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addOperationResponse")
    public AddOperationResponse addOperation(
        @WebParam(name = "addOperation", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addOperation")
        AddOperation addOperation,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param addPermission
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.AddPermissionResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "addPermissionResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addPermissionResponse")
    public AddPermissionResponse addPermission(
        @WebParam(name = "addPermission", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addPermission")
        AddPermission addPermission,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param raseaServiceHeader
     * @param addResource
     * @return
     *     returns org.rasea.agent.seam.proxy.AddResourceResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "addResourceResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addResourceResponse")
    public AddResourceResponse addResource(
        @WebParam(name = "addResource", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "addResource")
        AddResource addResource,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param applicationDetail
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.ApplicationDetailResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "applicationDetailResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "applicationDetailResponse")
    public ApplicationDetailResponse applicationDetail(
        @WebParam(name = "applicationDetail", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "applicationDetail")
        ApplicationDetail applicationDetail,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param assignOwner
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.AssignOwnerResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "assignOwnerResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "assignOwnerResponse")
    public AssignOwnerResponse assignOwner(
        @WebParam(name = "assignOwner", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "assignOwner")
        AssignOwner assignOwner,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param deassignOwner
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DeassignOwnerResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "deassignOwnerResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deassignOwnerResponse")
    public DeassignOwnerResponse deassignOwner(
        @WebParam(name = "deassignOwner", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deassignOwner")
        DeassignOwner deassignOwner,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param defaultApplicationName
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DefaultApplicationNameResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "defaultApplicationNameResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "defaultApplicationNameResponse")
    public DefaultApplicationNameResponse defaultApplicationName(
        @WebParam(name = "defaultApplicationName", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "defaultApplicationName")
        DefaultApplicationName defaultApplicationName,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param deleteApplication
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DeleteApplicationResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "deleteApplicationResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteApplicationResponse")
    public DeleteApplicationResponse deleteApplication(
        @WebParam(name = "deleteApplication", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteApplication")
        DeleteApplication deleteApplication,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param deleteOperation
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DeleteOperationResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "deleteOperationResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteOperationResponse")
    public DeleteOperationResponse deleteOperation(
        @WebParam(name = "deleteOperation", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteOperation")
        DeleteOperation deleteOperation,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param deletePermission
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DeletePermissionResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "deletePermissionResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deletePermissionResponse")
    public DeletePermissionResponse deletePermission(
        @WebParam(name = "deletePermission", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deletePermission")
        DeletePermission deletePermission,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param deleteResource
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.DeleteResourceResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "deleteResourceResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteResourceResponse")
    public DeleteResourceResponse deleteResource(
        @WebParam(name = "deleteResource", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "deleteResource")
        DeleteResource deleteResource,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param operationDetail
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.OperationDetailResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "operationDetailResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "operationDetailResponse")
    public OperationDetailResponse operationDetail(
        @WebParam(name = "operationDetail", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "operationDetail")
        OperationDetail operationDetail,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param resourceDetail
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.ResourceDetailResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "resourceDetailResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "resourceDetailResponse")
    public ResourceDetailResponse resourceDetail(
        @WebParam(name = "resourceDetail", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "resourceDetail")
        ResourceDetail resourceDetail,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

    /**
     * 
     * @param resourceOperations
     * @param raseaServiceHeader
     * @return
     *     returns org.rasea.agent.seam.proxy.ResourceOperationsResponse
     * @throws RaseaServiceException
     */
    @WebMethod
    @WebResult(name = "resourceOperationsResponse", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "resourceOperationsResponse")
    public ResourceOperationsResponse resourceOperations(
        @WebParam(name = "resourceOperations", targetNamespace = "http://rasea.org/ws/Maintenance", partName = "resourceOperations")
        ResourceOperations resourceOperations,
        @WebParam(name = "raseaServiceHeader", targetNamespace = "http://rasea.org/ws/Maintenance", header = true, partName = "raseaServiceHeader")
        RaseaServiceHeader raseaServiceHeader)
        throws RaseaServiceException
    ;

}
