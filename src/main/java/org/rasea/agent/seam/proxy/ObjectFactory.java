
package org.rasea.agent.seam.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.rasea.agent.seam.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeletePermissionResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "deletePermissionResponse");
    private final static QName _ResourceOperations_QNAME = new QName("http://rasea.org/ws/Maintenance", "resourceOperations");
    private final static QName _ResourceOperationsResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "resourceOperationsResponse");
    private final static QName _AddResourceResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "addResourceResponse");
    private final static QName _AssignOwner_QNAME = new QName("http://rasea.org/ws/Maintenance", "assignOwner");
    private final static QName _DeleteResourceResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteResourceResponse");
    private final static QName _OperationDetail_QNAME = new QName("http://rasea.org/ws/Maintenance", "operationDetail");
    private final static QName _ResourceDetail_QNAME = new QName("http://rasea.org/ws/Maintenance", "resourceDetail");
    private final static QName _DeleteApplicationResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteApplicationResponse");
    private final static QName _DeleteOperationResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteOperationResponse");
    private final static QName _OperationDetailResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "operationDetailResponse");
    private final static QName _AddOperationResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "addOperationResponse");
    private final static QName _DefaultApplicationNameResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "defaultApplicationNameResponse");
    private final static QName _DeleteResource_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteResource");
    private final static QName _DeleteOperation_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteOperation");
    private final static QName _ApplicationDetailResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "applicationDetailResponse");
    private final static QName _AddApplicationResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "addApplicationResponse");
    private final static QName _AddOperation_QNAME = new QName("http://rasea.org/ws/Maintenance", "addOperation");
    private final static QName _AddPermission_QNAME = new QName("http://rasea.org/ws/Maintenance", "addPermission");
    private final static QName _RaseaServiceHeader_QNAME = new QName("http://rasea.org/ws/Maintenance", "raseaServiceHeader");
    private final static QName _DeassignOwner_QNAME = new QName("http://rasea.org/ws/Maintenance", "deassignOwner");
    private final static QName _DeleteApplication_QNAME = new QName("http://rasea.org/ws/Maintenance", "deleteApplication");
    private final static QName _ApplicationDetail_QNAME = new QName("http://rasea.org/ws/Maintenance", "applicationDetail");
    private final static QName _DefaultApplicationName_QNAME = new QName("http://rasea.org/ws/Maintenance", "defaultApplicationName");
    private final static QName _AssignOwnerResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "assignOwnerResponse");
    private final static QName _DeassignOwnerResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "deassignOwnerResponse");
    private final static QName _RaseaServiceException_QNAME = new QName("http://rasea.org/ws/Maintenance", "RaseaServiceException");
    private final static QName _ResourceDetailResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "resourceDetailResponse");
    private final static QName _AddResource_QNAME = new QName("http://rasea.org/ws/Maintenance", "addResource");
    private final static QName _AddPermissionResponse_QNAME = new QName("http://rasea.org/ws/Maintenance", "addPermissionResponse");
    private final static QName _AddApplication_QNAME = new QName("http://rasea.org/ws/Maintenance", "addApplication");
    private final static QName _DeletePermission_QNAME = new QName("http://rasea.org/ws/Maintenance", "deletePermission");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.rasea.agent.seam.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteResourceResponse }
     * 
     */
    public DeleteResourceResponse createDeleteResourceResponse() {
        return new DeleteResourceResponse();
    }

    /**
     * Create an instance of {@link DeleteResource }
     * 
     */
    public DeleteResource createDeleteResource() {
        return new DeleteResource();
    }

    /**
     * Create an instance of {@link DeleteOperation }
     * 
     */
    public DeleteOperation createDeleteOperation() {
        return new DeleteOperation();
    }

    /**
     * Create an instance of {@link Application }
     * 
     */
    public Application createApplication() {
        return new Application();
    }

    /**
     * Create an instance of {@link ResourceDetail }
     * 
     */
    public ResourceDetail createResourceDetail() {
        return new ResourceDetail();
    }

    /**
     * Create an instance of {@link ApplicationDetail }
     * 
     */
    public ApplicationDetail createApplicationDetail() {
        return new ApplicationDetail();
    }

    /**
     * Create an instance of {@link DeletePermission }
     * 
     */
    public DeletePermission createDeletePermission() {
        return new DeletePermission();
    }

    /**
     * Create an instance of {@link AddResource }
     * 
     */
    public AddResource createAddResource() {
        return new AddResource();
    }

    /**
     * Create an instance of {@link AddResourceResponse }
     * 
     */
    public AddResourceResponse createAddResourceResponse() {
        return new AddResourceResponse();
    }

    /**
     * Create an instance of {@link AddOperationResponse }
     * 
     */
    public AddOperationResponse createAddOperationResponse() {
        return new AddOperationResponse();
    }

    /**
     * Create an instance of {@link AddApplication }
     * 
     */
    public AddApplication createAddApplication() {
        return new AddApplication();
    }

    /**
     * Create an instance of {@link AddOperation }
     * 
     */
    public AddOperation createAddOperation() {
        return new AddOperation();
    }

    /**
     * Create an instance of {@link ResourceOperations }
     * 
     */
    public ResourceOperations createResourceOperations() {
        return new ResourceOperations();
    }

    /**
     * Create an instance of {@link DeassignOwner }
     * 
     */
    public DeassignOwner createDeassignOwner() {
        return new DeassignOwner();
    }

    /**
     * Create an instance of {@link DefaultApplicationNameResponse }
     * 
     */
    public DefaultApplicationNameResponse createDefaultApplicationNameResponse() {
        return new DefaultApplicationNameResponse();
    }

    /**
     * Create an instance of {@link Resource }
     * 
     */
    public Resource createResource() {
        return new Resource();
    }

    /**
     * Create an instance of {@link OperationDetail }
     * 
     */
    public OperationDetail createOperationDetail() {
        return new OperationDetail();
    }

    /**
     * Create an instance of {@link DeletePermissionResponse }
     * 
     */
    public DeletePermissionResponse createDeletePermissionResponse() {
        return new DeletePermissionResponse();
    }

    /**
     * Create an instance of {@link DeleteApplicationResponse }
     * 
     */
    public DeleteApplicationResponse createDeleteApplicationResponse() {
        return new DeleteApplicationResponse();
    }

    /**
     * Create an instance of {@link DefaultApplicationName }
     * 
     */
    public DefaultApplicationName createDefaultApplicationName() {
        return new DefaultApplicationName();
    }

    /**
     * Create an instance of {@link AddPermissionResponse }
     * 
     */
    public AddPermissionResponse createAddPermissionResponse() {
        return new AddPermissionResponse();
    }

    /**
     * Create an instance of {@link AddPermission }
     * 
     */
    public AddPermission createAddPermission() {
        return new AddPermission();
    }

    /**
     * Create an instance of {@link AssignOwnerResponse }
     * 
     */
    public AssignOwnerResponse createAssignOwnerResponse() {
        return new AssignOwnerResponse();
    }

    /**
     * Create an instance of {@link RaseaServiceFault }
     * 
     */
    public RaseaServiceFault createRaseaServiceFault() {
        return new RaseaServiceFault();
    }

    /**
     * Create an instance of {@link DeassignOwnerResponse }
     * 
     */
    public DeassignOwnerResponse createDeassignOwnerResponse() {
        return new DeassignOwnerResponse();
    }

    /**
     * Create an instance of {@link AssignOwner }
     * 
     */
    public AssignOwner createAssignOwner() {
        return new AssignOwner();
    }

    /**
     * Create an instance of {@link ApplicationDetailResponse }
     * 
     */
    public ApplicationDetailResponse createApplicationDetailResponse() {
        return new ApplicationDetailResponse();
    }

    /**
     * Create an instance of {@link OperationDetailResponse }
     * 
     */
    public OperationDetailResponse createOperationDetailResponse() {
        return new OperationDetailResponse();
    }

    /**
     * Create an instance of {@link RaseaServiceHeader }
     * 
     */
    public RaseaServiceHeader createRaseaServiceHeader() {
        return new RaseaServiceHeader();
    }

    /**
     * Create an instance of {@link ResourceOperationsResponse }
     * 
     */
    public ResourceOperationsResponse createResourceOperationsResponse() {
        return new ResourceOperationsResponse();
    }

    /**
     * Create an instance of {@link DeleteOperationResponse }
     * 
     */
    public DeleteOperationResponse createDeleteOperationResponse() {
        return new DeleteOperationResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link DeleteApplication }
     * 
     */
    public DeleteApplication createDeleteApplication() {
        return new DeleteApplication();
    }

    /**
     * Create an instance of {@link AddApplicationResponse }
     * 
     */
    public AddApplicationResponse createAddApplicationResponse() {
        return new AddApplicationResponse();
    }

    /**
     * Create an instance of {@link ResourceDetailResponse }
     * 
     */
    public ResourceDetailResponse createResourceDetailResponse() {
        return new ResourceDetailResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePermissionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deletePermissionResponse")
    public JAXBElement<DeletePermissionResponse> createDeletePermissionResponse(DeletePermissionResponse value) {
        return new JAXBElement<DeletePermissionResponse>(_DeletePermissionResponse_QNAME, DeletePermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceOperations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "resourceOperations")
    public JAXBElement<ResourceOperations> createResourceOperations(ResourceOperations value) {
        return new JAXBElement<ResourceOperations>(_ResourceOperations_QNAME, ResourceOperations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceOperationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "resourceOperationsResponse")
    public JAXBElement<ResourceOperationsResponse> createResourceOperationsResponse(ResourceOperationsResponse value) {
        return new JAXBElement<ResourceOperationsResponse>(_ResourceOperationsResponse_QNAME, ResourceOperationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addResourceResponse")
    public JAXBElement<AddResourceResponse> createAddResourceResponse(AddResourceResponse value) {
        return new JAXBElement<AddResourceResponse>(_AddResourceResponse_QNAME, AddResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "assignOwner")
    public JAXBElement<AssignOwner> createAssignOwner(AssignOwner value) {
        return new JAXBElement<AssignOwner>(_AssignOwner_QNAME, AssignOwner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteResourceResponse")
    public JAXBElement<DeleteResourceResponse> createDeleteResourceResponse(DeleteResourceResponse value) {
        return new JAXBElement<DeleteResourceResponse>(_DeleteResourceResponse_QNAME, DeleteResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "operationDetail")
    public JAXBElement<OperationDetail> createOperationDetail(OperationDetail value) {
        return new JAXBElement<OperationDetail>(_OperationDetail_QNAME, OperationDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "resourceDetail")
    public JAXBElement<ResourceDetail> createResourceDetail(ResourceDetail value) {
        return new JAXBElement<ResourceDetail>(_ResourceDetail_QNAME, ResourceDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteApplicationResponse")
    public JAXBElement<DeleteApplicationResponse> createDeleteApplicationResponse(DeleteApplicationResponse value) {
        return new JAXBElement<DeleteApplicationResponse>(_DeleteApplicationResponse_QNAME, DeleteApplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteOperationResponse")
    public JAXBElement<DeleteOperationResponse> createDeleteOperationResponse(DeleteOperationResponse value) {
        return new JAXBElement<DeleteOperationResponse>(_DeleteOperationResponse_QNAME, DeleteOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "operationDetailResponse")
    public JAXBElement<OperationDetailResponse> createOperationDetailResponse(OperationDetailResponse value) {
        return new JAXBElement<OperationDetailResponse>(_OperationDetailResponse_QNAME, OperationDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addOperationResponse")
    public JAXBElement<AddOperationResponse> createAddOperationResponse(AddOperationResponse value) {
        return new JAXBElement<AddOperationResponse>(_AddOperationResponse_QNAME, AddOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultApplicationNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "defaultApplicationNameResponse")
    public JAXBElement<DefaultApplicationNameResponse> createDefaultApplicationNameResponse(DefaultApplicationNameResponse value) {
        return new JAXBElement<DefaultApplicationNameResponse>(_DefaultApplicationNameResponse_QNAME, DefaultApplicationNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteResource")
    public JAXBElement<DeleteResource> createDeleteResource(DeleteResource value) {
        return new JAXBElement<DeleteResource>(_DeleteResource_QNAME, DeleteResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteOperation")
    public JAXBElement<DeleteOperation> createDeleteOperation(DeleteOperation value) {
        return new JAXBElement<DeleteOperation>(_DeleteOperation_QNAME, DeleteOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "applicationDetailResponse")
    public JAXBElement<ApplicationDetailResponse> createApplicationDetailResponse(ApplicationDetailResponse value) {
        return new JAXBElement<ApplicationDetailResponse>(_ApplicationDetailResponse_QNAME, ApplicationDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addApplicationResponse")
    public JAXBElement<AddApplicationResponse> createAddApplicationResponse(AddApplicationResponse value) {
        return new JAXBElement<AddApplicationResponse>(_AddApplicationResponse_QNAME, AddApplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addOperation")
    public JAXBElement<AddOperation> createAddOperation(AddOperation value) {
        return new JAXBElement<AddOperation>(_AddOperation_QNAME, AddOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addPermission")
    public JAXBElement<AddPermission> createAddPermission(AddPermission value) {
        return new JAXBElement<AddPermission>(_AddPermission_QNAME, AddPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RaseaServiceHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "raseaServiceHeader")
    public JAXBElement<RaseaServiceHeader> createRaseaServiceHeader(RaseaServiceHeader value) {
        return new JAXBElement<RaseaServiceHeader>(_RaseaServiceHeader_QNAME, RaseaServiceHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeassignOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deassignOwner")
    public JAXBElement<DeassignOwner> createDeassignOwner(DeassignOwner value) {
        return new JAXBElement<DeassignOwner>(_DeassignOwner_QNAME, DeassignOwner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deleteApplication")
    public JAXBElement<DeleteApplication> createDeleteApplication(DeleteApplication value) {
        return new JAXBElement<DeleteApplication>(_DeleteApplication_QNAME, DeleteApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "applicationDetail")
    public JAXBElement<ApplicationDetail> createApplicationDetail(ApplicationDetail value) {
        return new JAXBElement<ApplicationDetail>(_ApplicationDetail_QNAME, ApplicationDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultApplicationName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "defaultApplicationName")
    public JAXBElement<DefaultApplicationName> createDefaultApplicationName(DefaultApplicationName value) {
        return new JAXBElement<DefaultApplicationName>(_DefaultApplicationName_QNAME, DefaultApplicationName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "assignOwnerResponse")
    public JAXBElement<AssignOwnerResponse> createAssignOwnerResponse(AssignOwnerResponse value) {
        return new JAXBElement<AssignOwnerResponse>(_AssignOwnerResponse_QNAME, AssignOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeassignOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deassignOwnerResponse")
    public JAXBElement<DeassignOwnerResponse> createDeassignOwnerResponse(DeassignOwnerResponse value) {
        return new JAXBElement<DeassignOwnerResponse>(_DeassignOwnerResponse_QNAME, DeassignOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RaseaServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "RaseaServiceException")
    public JAXBElement<RaseaServiceFault> createRaseaServiceException(RaseaServiceFault value) {
        return new JAXBElement<RaseaServiceFault>(_RaseaServiceException_QNAME, RaseaServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "resourceDetailResponse")
    public JAXBElement<ResourceDetailResponse> createResourceDetailResponse(ResourceDetailResponse value) {
        return new JAXBElement<ResourceDetailResponse>(_ResourceDetailResponse_QNAME, ResourceDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addResource")
    public JAXBElement<AddResource> createAddResource(AddResource value) {
        return new JAXBElement<AddResource>(_AddResource_QNAME, AddResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPermissionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addPermissionResponse")
    public JAXBElement<AddPermissionResponse> createAddPermissionResponse(AddPermissionResponse value) {
        return new JAXBElement<AddPermissionResponse>(_AddPermissionResponse_QNAME, AddPermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "addApplication")
    public JAXBElement<AddApplication> createAddApplication(AddApplication value) {
        return new JAXBElement<AddApplication>(_AddApplication_QNAME, AddApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePermission }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rasea.org/ws/Maintenance", name = "deletePermission")
    public JAXBElement<DeletePermission> createDeletePermission(DeletePermission value) {
        return new JAXBElement<DeletePermission>(_DeletePermission_QNAME, DeletePermission.class, null, value);
    }

}
