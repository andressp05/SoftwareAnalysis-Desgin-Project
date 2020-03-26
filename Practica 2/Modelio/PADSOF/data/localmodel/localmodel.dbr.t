`h�0  R                �� l      �   ORMAT_VERSION!�   �     #�   ORMAT_VERSION!�f	idx.users!    �    + 0�   dx.uses!fFORMAT_VERSION!�f	idx.users!    �    4 9�   dx.uses!fmain!fFORMAT_VERSION!�f	idx.users!  p�g3Ol<?xml version="1.0" encoding="UTF-8"?>
<metamodel format="1" MetamodelDescriptor.format="1">
  <fragment name="Infrastructure" version="2.0.00" provider="Modeliosoft" providerVersion="3.6.00">
    <dependencies>
      <metamodel_fragment name="modelio.kernel" version="1.0.00"/>
    </dependencies>
    <metaclasses>
      <metaclass name="AbstractDiagram" version="0.0.9054" abstract="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="UiDataVersion" type="java.lang.Integer"></attribute>
        <attribute name="UiData" type="java.lang.String"></attribute>
        <dependency name="Represented" min="0" max="-1" navigate="true" weakReference="true">
          <target fragment="Infrastructure" name="Element"/>
          <opposite name="DiagramElement"/>
        </dependency>
        <dependency name="ReferencingSet" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="DiagramSet"/>
          <opposite name="ReferencedDiagram"/>
        </dependency>
        <dependency name="Origin" min="0" max="1" navigate="true">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Product"/>
        </dependency>
      </metaclass>
      <metaclass name="AbstractProject" version="3.6.00" abstract="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="DiagramRoot" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="DiagramSet"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Dependency" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="Impacted" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="DependsOnDependency"/>
        </dependency>
        <dependency name="DependsOn" min="0" max="1" navigate="true">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="ImpactedDependency"/>
        </dependency>
        <sources>
          <dep name="Impacted"/>
        </sources>
        <targets>
          <dep name="DependsOn"/>
        </targets>
      </link_metaclass>
      <metaclass name="DiagramSet" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="Sub" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="DiagramSet"/>
          <opposite name="Parent"/>
        </dependency>
        <dependency name="Parent" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="DiagramSet"/>
          <opposite name="Sub"/>
        </dependency>
        <dependency name="ReferencedDiagram" min="0" max="-1" navigate="true">
          <target fragment="Infrastructure" name="AbstractDiagram"/>
          <opposite name="ReferencingSet"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="AbstractProject"/>
          <opposite name="DiagramRoot"/>
        </dependency>
      </metaclass>
      <metaclass name="DynamicPropertyDefinition" version="1.1.01">
        <parent fragment="Infrastructure" name="PropertyDefinition"/>
      </metaclass>
      <metaclass name="Element" version="0.0.9054" abstract="true">
        <parent fragment="modelio.kernel" name="SmObject"/>
        <dependency name="DiagramElement" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="AbstractDiagram"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="AddedToQuery" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="Added"/>
        </dependency>
        <dependency name="causedImpact" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ImpactLink"/>
          <opposite name="causes"/>
        </dependency>
      </metaclass>
      <metaclass name="EnumeratedPropertyType" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="PropertyType"/>
        <dependency name="Litteral" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyEnumerationLitteral"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="OccurenceConfigParam" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ModuleParameter"/>
          <opposite name="EnumType"/>
        </dependency>
      </metaclass>
      <metaclass name="ExternDocument" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="MimeType" type="java.lang.String"></attribute>
        <attribute name="Path" type="java.lang.String"></attribute>
        <attribute name="Abstract" type="java.lang.String"></attribute>
        <dependency name="Type" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="ExternDocumentType"/>
          <opposite name="TypedDoc"/>
        </dependency>
        <dependency name="Subject" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Document"/>
        </dependency>
      </metaclass>
      <metaclass name="ExternDocumentType" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="IsHidden" type="java.lang.Boolean"></attribute>
        <attribute name="LabelKey" type="java.lang.String"></attribute>
        <attribute name="Icon" type="java.lang.String"></attribute>
        <attribute name="Image" type="java.lang.String"></attribute>
        <dependency name="OwnerStereotype" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="DefinedExternDocumentType"/>
        </dependency>
        <dependency name="TypedDoc" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="ExternDocument"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="OwnerReference" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MetaclassReference"/>
          <opposite name="DefinedExternDocumentType"/>
        </dependency>
      </metaclass>
      <metaclass name="ExternProcessor" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="ClassName" type="java.lang.String"></attribute>
        <dependency name="OwnerQuery" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="Processor"/>
        </dependency>
        <dependency name="OwnerValDef" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixValueDefinition"/>
          <opposite name="Processor"/>
        </dependency>
      </metaclass>
      <metaclass name="ImpactDiagram" version="3.6.00" cmsNode="true">
        <parent fragment="Infrastructure" name="AbstractDiagram"/>
      </metaclass>
      <link_metaclass name="ImpactLink" version="3.6.00">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="dependsOn" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="impactImpacted"/>
        </dependency>
        <dependency name="impacted" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="impactDependsOn"/>
�0  R                        </dependency>
        <dependency name="causes" min="0" max="-1" navigate="true">
          <target fragment="Infrastructure" name="Element"/>
          <opposite name="causedImpact"/>
        </dependency>
        <dependency name="owner" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="ImpactModel"/>
          <opposite name="ownedLinks"/>
        </dependency>
        <sources>
          <dep name="impacted"/>
        </sources>
        <targets>
          <dep name="dependsOn"/>
        </targets>
      </link_metaclass>
      <metaclass name="ImpactModel" version="3.6.00" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="project" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="ImpactProject"/>
          <opposite name="model"/>
        </dependency>
        <dependency name="ownedLinks" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="ImpactLink"/>
          <opposite name="owner"/>
        </dependency>
      </metaclass>
      <metaclass name="ImpactProject" version="3.6.00" cmsNode="true">
        <parent fragment="Infrastructure" name="AbstractProject"/>
        <dependency name="model" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ImpactModel"/>
          <opposite name="project"/>
        </dependency>
      </metaclass>
      <metaclass name="LocalPropertyTable" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="PropertyTable"/>
        <dependency name="LocalAnnoted" min="0" max="1" navigate="true">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="LocalProperties"/>
        </dependency>
      </metaclass>
      <metaclass name="MatrixDefinition" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="LinesDefinition" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="OwnerAsLine"/>
        </dependency>
        <dependency name="ColumnsDefinition" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="OwnerAsCol"/>
        </dependency>
        <dependency name="ValuesDefinition" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="MatrixValueDefinition"/>
          <opposite name="Matrix"/>
        </dependency>
        <dependency name="DepthDefinition" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="OwnerAsDepth"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Matrix"/>
        </dependency>
      </metaclass>
      <metaclass name="MatrixValueDefinition" version="0.0.9054">
        <parent fragment="Infrastructure" name="Element"/>
        <dependency name="Processor" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ExternProcessor"/>
          <opposite name="OwnerValDef"/>
        </dependency>
        <dependency name="Parameters" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyTable"/>
          <opposite name="OwnerValDef"/>
        </dependency>
        <dependency name="Matrix" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixDefinition"/>
          <opposite name="ValuesDefinition"/>
        </dependency>
      </metaclass>
      <metaclass name="MetaclassReference" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="Element"/>
        <attribute name="ReferencedClassName" type="java.lang.String"></attribute>
        <dependency name="DefinedTable" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyTableDefinition"/>
          <opposite name="OwnerReference"/>
        </dependency>
        <dependency name="DefinedNoteType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="NoteType"/>
          <opposite name="OwnerReference"/>
        </dependency>
        <dependency name="DefinedExternDocumentType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ExternDocumentType"/>
          <opposite name="OwnerReference"/>
        </dependency>
        <dependency name="OwnerProfile" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="Profile"/>
          <opposite name="OwnedReference"/>
        </dependency>
        <dependency name="DefinedTagType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="TagType"/>
          <opposite name="OwnerReference"/>
        </dependency>
      </metaclass>
      <metaclass name="ModelElement" version="3.6.00" abstract="true">
        <parent fragment="Infrastructure" name="Element"/>
        <attribute name="Name" type="java.lang.String"></attribute>
        <dependency name="LocalProperties" min="0" max="1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="LocalPropertyTable"/>
          <opposite name="LocalAnnoted"/>
        </dependency>
        <dependency name="Extension" min="0" max="-1" navigate="true">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="ExtendedElement"/>
        </dependency>
        <dependency name="DependsOnDependency" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="Dependency"/>
          <opposite name="Impacted"/>
        </dependency>
        <dependency name="Document" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ExternDocument"/>
          <opposite name="Subject"/>
        </dependency>
        <dependency name="Tag" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="TaggedValue"/>
          <opposite name="Annoted"/>
        </dependency>
        <dependency name="ImpactedDependency" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="Dependency"/>
          <opposite name="DependsOn"/>
        </dependency>
        <dependency name="Properties" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyTable"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="Product" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="AbstractDiagram"/>
          <opposite name="Origin"/>
        </dependency>
        <dependency name="Descriptor" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="Note"/>
          <opposite name="Subject"/>
        </dependency>
        <dependency name="Matrix" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="MatrixDefinition"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="impactImpacted" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ImpactLink"/>
          <opposite name="dependsOn"/>
        </dependency>
        <dependency name="impactDependsOn" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ImpactLink"/>
          <opposite name="impacted"/>
        </dependency>
      </me�0  R                taclass>
      <metaclass name="ModuleComponent" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="AbstractProject"/>
        <attribute name="LicenseKey" type="java.lang.Integer"></attribute>
        <attribute name="MajVersion" type="java.lang.Integer"></attribute>
        <attribute name="MinVersion" type="java.lang.Integer"></attribute>
        <attribute name="MinMinVersion" type="java.lang.String"></attribute>
        <attribute name="MinBinVersionCompatibility" type="java.lang.String"></attribute>
        <attribute name="JavaClassName" type="java.lang.String"></attribute>
        <dependency name="DefinedPropertyType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyType"/>
          <opposite name="ModuleOwner"/>
        </dependency>
        <dependency name="OwnedProfile" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="Profile"/>
          <opposite name="OwnerModule"/>
        </dependency>
        <dependency name="ModuleParameter" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ModuleParameter"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="DependsOn" min="0" max="-1" navigate="true">
          <target fragment="Infrastructure" name="ModuleComponent"/>
          <opposite name="Impacted"/>
        </dependency>
        <dependency name="Impacted" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ModuleComponent"/>
          <opposite name="DependsOn"/>
        </dependency>
      </metaclass>
      <metaclass name="ModuleParameter" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="GroupName" type="java.lang.String"></attribute>
        <attribute name="Type" type="java.lang.Enum" enumType="org.modelio.metamodel.mda.ModuleParameterType"></attribute>
        <attribute name="IsUserRead" type="java.lang.Boolean"></attribute>
        <attribute name="IsUserWrite" type="java.lang.Boolean"></attribute>
        <attribute name="IsApiRead" type="java.lang.Boolean"></attribute>
        <attribute name="IsApiWrite" type="java.lang.Boolean"></attribute>
        <attribute name="DefaultValue" type="java.lang.String"></attribute>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModuleComponent"/>
          <opposite name="ModuleParameter"/>
        </dependency>
        <dependency name="EnumType" min="0" max="1" navigate="true">
          <target fragment="Infrastructure" name="EnumeratedPropertyType"/>
          <opposite name="OccurenceConfigParam"/>
        </dependency>
      </metaclass>
      <metaclass name="Note" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="Content" type="java.lang.String"></attribute>
        <attribute name="MimeType" type="java.lang.String"></attribute>
        <dependency name="Model" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="NoteType"/>
          <opposite name="Element"/>
        </dependency>
        <dependency name="Subject" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Descriptor"/>
        </dependency>
      </metaclass>
      <metaclass name="NoteType" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="IsHidden" type="java.lang.Boolean"></attribute>
        <attribute name="LabelKey" type="java.lang.String"></attribute>
        <attribute name="MimeType" type="java.lang.String"></attribute>
        <dependency name="Element" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="Note"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="OwnerStereotype" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="DefinedNoteType"/>
        </dependency>
        <dependency name="OwnerReference" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MetaclassReference"/>
          <opposite name="DefinedNoteType"/>
        </dependency>
      </metaclass>
      <metaclass name="Profile" version="3.6.00" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="DefinedStereotype" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="OwnedReference" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="MetaclassReference"/>
          <opposite name="OwnerProfile"/>
        </dependency>
        <dependency name="OwnerModule" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModuleComponent"/>
          <opposite name="OwnedProfile"/>
        </dependency>
        <dependency name="DefinedType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyType"/>
          <opposite name="AnalystOwner"/>
        </dependency>
      </metaclass>
      <metaclass name="PropertyDefinition" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="IsEditable" type="java.lang.Boolean"></attribute>
        <attribute name="DefaultValue" type="java.lang.String"></attribute>
        <dependency name="Type" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="PropertyType"/>
          <opposite name="Typed"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="PropertyTableDefinition"/>
          <opposite name="Owned"/>
        </dependency>
      </metaclass>
      <metaclass name="PropertyEnumerationLitteral" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="EnumeratedPropertyType"/>
          <opposite name="Litteral"/>
        </dependency>
      </metaclass>
      <metaclass name="PropertyTable" version="0.0.9054">
        <parent fragment="Infrastructure" name="Element"/>
        <attribute name="Name" type="java.lang.String"></attribute>
        <attribute name="Content" type="java.lang.String"></attribute>
        <dependency name="OwnerValDef" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixValueDefinition"/>
          <opposite name="Parameters"/>
        </dependency>
        <dependency name="OwnerQuery" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="QueryDefinition"/>
          <opposite name="Parameters"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Properties"/>
        </dependency>
      </metaclass>
      <metaclass name="PropertyTableDefinition" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="TypedTable" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="TypedPropertyTable"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="OwnerReference" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MetaclassReference"/>
          <opposite name="DefinedTable"/>
        </dependency>
        <dependency name="OwnerStereotype" min="0" max="1" navigate="false">
          <target fragment="Infrast�0  R                ructure" name="Stereotype"/>
          <opposite name="DefinedTable"/>
        </dependency>
        <dependency name="Owned" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyDefinition"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="PropertyType" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="BaseType" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.infrastructure.properties.PropertyBaseType"></attribute>
        <dependency name="ModuleOwner" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModuleComponent"/>
          <opposite name="DefinedPropertyType"/>
        </dependency>
        <dependency name="Typed" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="PropertyDefinition"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="AnalystOwner" min="1" max="1" navigate="false">
          <target fragment="Infrastructure" name="Profile"/>
          <opposite name="DefinedType"/>
        </dependency>
      </metaclass>
      <metaclass name="QueryDefinition" version="0.0.9054">
        <parent fragment="Infrastructure" name="Element"/>
        <attribute name="UsingAdditions" type="java.lang.Boolean"></attribute>
        <dependency name="Added" min="0" max="-1" navigate="true">
          <target fragment="Infrastructure" name="Element"/>
          <opposite name="AddedToQuery"/>
        </dependency>
        <dependency name="Processor" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ExternProcessor"/>
          <opposite name="OwnerQuery"/>
        </dependency>
        <dependency name="Parameters" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyTable"/>
          <opposite name="OwnerQuery"/>
        </dependency>
        <dependency name="OwnerAsLine" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixDefinition"/>
          <opposite name="LinesDefinition"/>
        </dependency>
        <dependency name="OwnerAsCol" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixDefinition"/>
          <opposite name="ColumnsDefinition"/>
        </dependency>
        <dependency name="OwnerAsDepth" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MatrixDefinition"/>
          <opposite name="DepthDefinition"/>
        </dependency>
      </metaclass>
      <metaclass name="Stereotype" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="Image" type="java.lang.String"></attribute>
        <attribute name="Icon" type="java.lang.String"></attribute>
        <attribute name="IsHidden" type="java.lang.Boolean"></attribute>
        <attribute name="LabelKey" type="java.lang.String"></attribute>
        <attribute name="BaseClassName" type="java.lang.String"></attribute>
        <dependency name="DefinedTable" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="PropertyTableDefinition"/>
          <opposite name="OwnerStereotype"/>
        </dependency>
        <dependency name="DefinedExternDocumentType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="ExternDocumentType"/>
          <opposite name="OwnerStereotype"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="Profile"/>
          <opposite name="DefinedStereotype"/>
        </dependency>
        <dependency name="Parent" min="0" max="1" navigate="true">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="Child"/>
        </dependency>
        <dependency name="DefinedTagType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="TagType"/>
          <opposite name="OwnerStereotype"/>
        </dependency>
        <dependency name="Child" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="Parent"/>
        </dependency>
        <dependency name="DefinedNoteType" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="NoteType"/>
          <opposite name="OwnerStereotype"/>
        </dependency>
        <dependency name="ExtendedElement" min="0" max="-1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Extension"/>
        </dependency>
      </metaclass>
      <metaclass name="TagParameter" version="0.0.9054">
        <parent fragment="Infrastructure" name="Element"/>
        <attribute name="Value" type="java.lang.String"></attribute>
        <dependency name="Annoted" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="TaggedValue"/>
          <opposite name="Actual"/>
        </dependency>
        <dependency name="Qualified" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="TaggedValue"/>
          <opposite name="Qualifier"/>
        </dependency>
      </metaclass>
      <metaclass name="TagType" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <attribute name="ParamNumber" type="java.lang.String"></attribute>
        <attribute name="IsQualified" type="java.lang.Boolean"></attribute>
        <attribute name="BelongToPrototype" type="java.lang.Boolean"></attribute>
        <attribute name="IsHidden" type="java.lang.Boolean"></attribute>
        <attribute name="LabelKey" type="java.lang.String"></attribute>
        <dependency name="TagOccurence" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Infrastructure" name="TaggedValue"/>
          <opposite name="Definition"/>
        </dependency>
        <dependency name="OwnerStereotype" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="Stereotype"/>
          <opposite name="DefinedTagType"/>
        </dependency>
        <dependency name="OwnerReference" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="MetaclassReference"/>
          <opposite name="DefinedTagType"/>
        </dependency>
      </metaclass>
      <metaclass name="TaggedValue" version="0.0.9054">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="Actual" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="TagParameter"/>
          <opposite name="Annoted"/>
        </dependency>
        <dependency name="Qualifier" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Infrastructure" name="TagParameter"/>
          <opposite name="Qualified"/>
        </dependency>
        <dependency name="Definition" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="TagType"/>
          <opposite name="TagOccurence"/>
        </dependency>
        <dependency name="Annoted" min="0" max="1" navigate="false">
          <target fragment="Infrastructure" name="ModelElement"/>
          <opposite name="Tag"/>
        </dependency>
      </metaclass>
      <metaclass name="TypedPropertyTable" version="0.0.9054">
        <parent fragment="Infrastructure" name="PropertyTable"/>
        <dependency name="Type" min="1" max="1" navigate="true">
          <target fragment="Infrastructure" name="PropertyTableDefinition"/>
          <opposite name="TypedTable"/>
        </dependency>
      </metaclass>
    </metaclasses>
    <enumerations>
      <enumeration name="org.modelio.metamodel.mda.ModuleParameterType">
    �0  R                    <value name="TYPE_PARAM_BOOLEAN"/>
        <value name="TYPE_PARAM_STRING"/>
        <value name="TYPE_PARAM_ENUM"/>
        <value name="TYPE_PARAM_FILE"/>
        <value name="TYPE_PARAM_INTEGER"/>
        <value name="TYPE_PARAM_DIRECTORY"/>
        <value name="TYPE_PARAM_PASSWORD"/>
        <value name="TYPE_PARAM_COLOR"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.infrastructure.properties.PropertyBaseType">
        <value name="STRING"/>
        <value name="TEXT"/>
        <value name="BOOLEAN"/>
        <value name="INTEGER"/>
        <value name="UNSIGNED"/>
        <value name="FLOAT"/>
        <value name="ENUMERATE"/>
        <value name="DATE"/>
        <value name="TIME"/>
        <value name="ELEMENT"/>
        <value name="RICHTEXT"/>
        <value name="MULTISTRING"/>
        <value name="MULTIELEMENT"/>
      </enumeration>
    </enumerations>
  </fragment>
  <fragment name="Standard" version="2.0.00" provider="Modeliosoft" providerVersion="3.6.00">
    <dependencies>
      <metamodel_fragment name="modelio.kernel" version="1.0.00"/>
      <metamodel_fragment name="Infrastructure" version="2.0.00"/>
    </dependencies>
    <metaclasses>
      <metaclass name="AbstractPseudoState" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="StateVertex"/>
      </metaclass>
      <link_metaclass name="Abstraction" version="0.0.9054">
        <parent fragment="Infrastructure" name="Dependency"/>
        <attribute name="Mapping" type="java.lang.String"></attribute>
        <sources>
          <dep name="Impacted"/>
        </sources>
        <targets>
          <dep name="DependsOn"/>
        </targets>
      </link_metaclass>
      <metaclass name="AcceptCallEventAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <dependency name="Called" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="EntryPointAction"/>
        </dependency>
      </metaclass>
      <metaclass name="AcceptChangeEventAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <attribute name="ChangeExpresion" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="AcceptSignalAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <dependency name="Accepted" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="Receiver"/>
        </dependency>
      </metaclass>
      <metaclass name="AcceptTimeEventAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <attribute name="TimeExpresion" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="Activity" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <attribute name="IsSingleExecution" type="java.lang.Boolean"></attribute>
        <attribute name="IsReadOnly" type="java.lang.Boolean"></attribute>
        <dependency name="OwnedGroup" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityGroup"/>
          <opposite name="InActivity"/>
        </dependency>
        <dependency name="OwnedNode" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="ActivityAction" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ActivityNode"/>
        <attribute name="IsMultipleInstance" type="java.lang.Boolean"></attribute>
        <attribute name="IsCompensation" type="java.lang.Boolean"></attribute>
        <dependency name="Output" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="OutputPin"/>
          <opposite name="Outputing"/>
        </dependency>
        <dependency name="Input" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InputPin"/>
          <opposite name="Inputing"/>
        </dependency>
        <dependency name="Handler" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExceptionHandler"/>
          <opposite name="ProtectedNode"/>
        </dependency>
      </metaclass>
      <metaclass name="ActivityDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
        <attribute name="IsVertical" type="java.lang.Boolean"></attribute>
      </metaclass>
      <link_metaclass name="ActivityEdge" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Guard" type="java.lang.String"></attribute>
        <attribute name="Weight" type="java.lang.String"></attribute>
        <dependency name="Target" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="Incoming"/>
        </dependency>
        <dependency name="Source" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="Outgoing"/>
        </dependency>
        <dependency name="Interrupts" min="0" max="1" navigate="false">
          <target fragment="Standard" name="InterruptibleActivityRegion"/>
          <opposite name="InterruptingEdge"/>
        </dependency>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingActivityEdge"/>
        </dependency>
        <sources>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="ActivityFinalNode" version="0.0.9054">
        <parent fragment="Standard" name="FinalNode"/>
      </metaclass>
      <metaclass name="ActivityGroup" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="InActivity" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Activity"/>
          <opposite name="OwnedGroup"/>
        </dependency>
      </metaclass>
      <metaclass name="ActivityNode" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Activity"/>
          <opposite name="OwnedNode"/>
        </dependency>
        <dependency name="OwnerPartition" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="ContainedNode"/>
        </dependency>
        <dependency name="Incoming" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="ActivityEdge"/>
          <opposite name="Target"/>
        </dependency>
        <dependency name="OwnerClause" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Clause"/>
          <opposite name="Body"/>
        </dependency>
        <dependency name="OwnerNode" min="0" max="1" navigate="false">
          <target fragment="Standard" name="StructuredActivityNode"/>
          <opposite name="Body"/>
        </dependency>
        <dependency name="Outgoing" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityEdge"/>
          <opposite name="Source"/>
        </dependency>
      </metaclass>
      <metaclass name="ActivityParameterNode" version="0.0.9054">
        <parent fragment="Standard" name="ObjectNode"/>
      </metaclass>
      <metaclass name="ActivityPartition" version="0.0.9054">
        <parent fragment="Standard" name="ActivityGroup"/>
        <attribute name="IsDimension" type="java.lang.Boolean"></attribute>
 �0  R                       <attribute name="IsExternal" type="java.lang.Boolean"></attribute>
        <dependency name="Represented" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="RepresentingPartition"/>
        </dependency>
        <dependency name="ContainedNode" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="OwnerPartition"/>
        </dependency>
        <dependency name="Outgoing" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="MessageFlow"/>
          <opposite name="SourcePartition"/>
        </dependency>
        <dependency name="SuperPartition" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="SubPartition"/>
        </dependency>
        <dependency name="SubPartition" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="SuperPartition"/>
        </dependency>
        <dependency name="Incoming" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="MessageFlow"/>
          <opposite name="TargetPartition"/>
        </dependency>
      </metaclass>
      <metaclass name="Actor" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
      </metaclass>
      <metaclass name="Artifact" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Classifier"/>
        <attribute name="FileName" type="java.lang.String"></attribute>
        <dependency name="Utilized" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Manifestation"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="DeploymentLocation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Node"/>
          <opposite name="Resident"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Association" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Link"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="End" min="2" max="2" navigate="false">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Association"/>
        </dependency>
        <dependency name="LinkToClass" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ClassAssociation"/>
          <opposite name="AssociationPart"/>
        </dependency>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <link_metaclass name="AssociationEnd" version="0.0.9054">
        <parent fragment="Standard" name="StructuralFeature"/>
        <attribute name="Aggregation" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.AggregationKind"></attribute>
        <attribute name="IsChangeable" type="java.lang.Boolean"></attribute>
        <dependency name="Target" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="TargetingEnd"/>
        </dependency>
        <dependency name="OppositeOwner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Opposite"/>
        </dependency>
        <dependency name="Source" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="OwnedEnd"/>
        </dependency>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="Sent" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="Channel"/>
        </dependency>
        <dependency name="Qualifier" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="Qualified"/>
        </dependency>
        <dependency name="Opposite" min="1" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="OppositeOwner"/>
        </dependency>
        <dependency name="RepresentingObjectNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="RepresentedRole"/>
        </dependency>
        <dependency name="Association" min="0" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="Association"/>
          <opposite name="End"/>
        </dependency>
        <dependency name="RepresentingItem" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="RepresentedAssociationEnd"/>
        </dependency>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <metaclass name="Attribute" version="0.0.9054">
        <parent fragment="Standard" name="StructuralFeature"/>
        <attribute name="TypeConstraint" type="java.lang.String"></attribute>
        <attribute name="Value" type="java.lang.String"></attribute>
        <attribute name="TargetIsClass" type="java.lang.Boolean"></attribute>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="Object"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="OwnedAttribute"/>
        </dependency>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="AttributeLink"/>
          <opposite name="Base"/>
        </dependency>
        <dependency name="RepresentingItem" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="RepresentedAttribute"/>
        </dependency>
        <dependency name="RepresentingObjectNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="RepresentedAttribute"/>
        </dependency>
        <dependency name="Qualified" min="0" max="1" navigate="false">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Qualifier"/>
        </dependency>
      </metaclass>
      <metaclass name="AttributeLink" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Value" type="java.lang.String"></attribute>
        <dependency name="Attributed" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Instance"/>
          <opposite name="Slot"/>
        </dependency>
        <dependency name="Base" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="Occurence"/>
        </dependency>
      </metaclass>
      <metaclass name="Behavior" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="IsReentrant" type="java.lang.Boolean"></attribute>
        <dependency name="BpmnCaller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnCallActivity"/>
          <opposite name="CalledBehavior"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="OwnedBehavior"/>
        </dependency>
        <dependency na�0  R                me="Parameter" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BehaviorParameter"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="OwnerOperation" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="OwnedBehavior"/>
        </dependency>
        <dependency name="OwnedCollaboration" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Collaboration"/>
          <opposite name="BRepresented"/>
        </dependency>
        <dependency name="Caller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CallBehaviorAction"/>
          <opposite name="Called"/>
        </dependency>
        <dependency name="EComponent" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Event"/>
          <opposite name="Composed"/>
        </dependency>
        <dependency name="EffectOf" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Transition"/>
          <opposite name="BehaviorEffect"/>
        </dependency>
      </metaclass>
      <metaclass name="BehaviorDiagram" version="0.0.9054" abstract="true">
        <parent fragment="Infrastructure" name="AbstractDiagram"/>
      </metaclass>
      <metaclass name="BehaviorParameter" version="0.0.9054">
        <parent fragment="Standard" name="Parameter"/>
        <dependency name="RepresentingObjectNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="RepresentedRealParameter"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="Parameter"/>
        </dependency>
        <dependency name="Mapped" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="BehaviorParam"/>
        </dependency>
      </metaclass>
      <metaclass name="BehavioralFeature" version="0.0.9054">
        <parent fragment="Standard" name="Feature"/>
      </metaclass>
      <metaclass name="BindableInstance" version="0.0.9054">
        <parent fragment="Standard" name="Instance"/>
        <dependency name="Cluster" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Instance"/>
          <opposite name="Part"/>
        </dependency>
        <dependency name="InternalOwner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="InternalStructure"/>
        </dependency>
        <dependency name="Representation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Binding"/>
          <opposite name="Role"/>
        </dependency>
        <dependency name="RepresentedFeature" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="RepresentingInstance"/>
        </dependency>
      </metaclass>
      <metaclass name="Binding" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="ConnectorEndRole" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ConnectorEnd"/>
          <opposite name="Representation"/>
        </dependency>
        <dependency name="ConnectorRole" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NaryConnector"/>
          <opposite name="Representation"/>
        </dependency>
        <dependency name="Role" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BindableInstance"/>
          <opposite name="Representation"/>
        </dependency>
        <dependency name="RepresentedFeature" min="1" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="Represents"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CollaborationUse"/>
          <opposite name="RoleBinding"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnActivity" version="0.0.9054">
        <parent fragment="Standard" name="BpmnFlowNode"/>
        <attribute name="IsForCompensation" type="java.lang.Boolean"></attribute>
        <attribute name="StartQuantity" type="java.lang.Integer"></attribute>
        <attribute name="CompletionQuantity" type="java.lang.Integer"></attribute>
        <dependency name="CompensateEventDefinitions" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnCompensateEventDefinition"/>
          <opposite name="ActivityRef"/>
        </dependency>
        <dependency name="InputSpecification" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataInput"/>
          <opposite name="OwnerActivity"/>
        </dependency>
        <dependency name="DataInputAssociation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="StartingActivity"/>
        </dependency>
        <dependency name="OutputSpecification" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataOutput"/>
          <opposite name="OwnerActivity"/>
        </dependency>
        <dependency name="LoopCharacteristics" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnLoopCharacteristics"/>
          <opposite name="OwnerActivity"/>
        </dependency>
        <dependency name="BoundaryEventRef" min="0" max="-1" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="BpmnBoundaryEvent"/>
          <opposite name="AttachedToRef"/>
        </dependency>
        <dependency name="DataOutputAssociation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="EndingActivity"/>
        </dependency>
        <dependency name="DefaultFlow" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="DefaultFrom"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnAdHocSubProcess" version="0.0.9054">
        <parent fragment="Standard" name="BpmnSubProcess"/>
        <attribute name="Ordering" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.activities.AdHocOrdering"></attribute>
        <attribute name="CancelRemainingInstances" type="java.lang.Boolean"></attribute>
        <attribute name="CompletionCondition" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnArtifact" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="SubProcess" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnSubProcess"/>
          <opposite name="Artifact"/>
        </dependency>
        <dependency name="Collaboration" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnCollaboration"/>
          <opposite name="Artifact"/>
        </dependency>
        <dependency name="Process" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Artifact"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnAssociation" version="0.0.9054">
        <parent fragment="Standard" name="BpmnArtifact"/>
        <attribute name="AssociationDirection" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.rootElements.BpmnAssociationDirection"></attribute>
        <dependency name="TargetRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnBaseElement"/>
          <opposite name="IncomingAss�0  R       	         oc"/>
        </dependency>
        <dependency name="SourceRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnBaseElement"/>
          <opposite name="OutgoingAssoc"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnBaseElement" version="0.0.9054" abstract="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="OutgoingAssoc" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnAssociation"/>
          <opposite name="SourceRef"/>
        </dependency>
        <dependency name="IncomingAssoc" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnAssociation"/>
          <opposite name="TargetRef"/>
        </dependency>
        <dependency name="IncomingFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessageFlow"/>
          <opposite name="TargetRef"/>
        </dependency>
        <dependency name="OutgoingFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessageFlow"/>
          <opposite name="SourceRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnBehavior" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <dependency name="RootElement" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnRootElement"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnBoundaryEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnCatchEvent"/>
        <attribute name="CancelActivity" type="java.lang.Boolean"></attribute>
        <dependency name="AttachedToRef" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="BoundaryEventRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnBusinessRuleTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
      </metaclass>
      <metaclass name="BpmnCallActivity" version="0.0.9054">
        <parent fragment="Standard" name="BpmnActivity"/>
        <dependency name="CalledGlobalTask" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnTask"/>
          <opposite name="Caller"/>
        </dependency>
        <dependency name="CalledProcess" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Caller"/>
        </dependency>
        <dependency name="CalledOperation" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Caller"/>
        </dependency>
        <dependency name="CalledBehavior" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="BpmnCaller"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnCancelEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
      </metaclass>
      <metaclass name="BpmnCatchEvent" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnEvent"/>
        <attribute name="ParallelMultiple" type="java.lang.Boolean"></attribute>
        <dependency name="DataOutputAssociation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="EndingEvent"/>
        </dependency>
        <dependency name="DataOutput" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataOutput"/>
          <opposite name="Catched"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnCollaboration" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <attribute name="IsClosed" type="java.lang.Boolean"></attribute>
        <dependency name="Artifact" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnArtifact"/>
          <opposite name="Collaboration"/>
        </dependency>
        <dependency name="MessageFlow" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnMessageFlow"/>
          <opposite name="Collaboration"/>
        </dependency>
        <dependency name="Participants" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="Container"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnCompensateEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <attribute name="WaitForCompletion" type="java.lang.String"></attribute>
        <dependency name="ActivityRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="CompensateEventDefinitions"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnComplexBehaviorDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="Condition" type="java.lang.String"></attribute>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnMultiInstanceLoopCharacteristics"/>
          <opposite name="ComplexBehaviorDefinition"/>
        </dependency>
        <dependency name="Event" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnImplicitThrowEvent"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnComplexGateway" version="0.0.9054">
        <parent fragment="Standard" name="BpmnGateway"/>
        <attribute name="ActivationExpression" type="java.lang.String"></attribute>
        <dependency name="DefaultFlow" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="DefaultOfComplex"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnConditionalEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <attribute name="Condition" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnDataAssociation" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="Assignment" type="java.lang.String"></attribute>
        <attribute name="Transfomation" type="java.lang.String"></attribute>
        <attribute name="Language" type="java.lang.String"></attribute>
        <dependency name="SourceRef" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="SourceOfDataAssociation"/>
        </dependency>
        <dependency name="TargetRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="TargetOfDataAssociation"/>
        </dependency>
        <dependency name="EndingActivity" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="DataOutputAssociation"/>
        </dependency>
        <dependency name="StartingActivity" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="DataInputAssociation"/>
        </dependency>
        <dependency name="StartingEvent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnThrowEvent"/>
          <opposite name="DataInputAssociation"/>
        </dependency>
        <dependency name="VisualShortCut" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnSequenceFlowDataAssociation"/>
          <opposite name="DataAssociation"/>
        </dependency>
     �0  R       
            <dependency name="EndingEvent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnCatchEvent"/>
          <opposite name="DataOutputAssociation"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnDataInput" version="0.0.9054">
        <parent fragment="Standard" name="BpmnItemAwareElement"/>
        <attribute name="IsCollection" type="java.lang.Boolean"></attribute>
        <dependency name="RepresentedParameter" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="BpmnRepresentingDataInput"/>
        </dependency>
        <dependency name="OwnerLoopCharacteristics" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnMultiInstanceLoopCharacteristics"/>
          <opposite name="LoopDataInput"/>
        </dependency>
        <dependency name="OwnerActivity" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="InputSpecification"/>
        </dependency>
        <dependency name="OwnerThrowEvent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnThrowEvent"/>
          <opposite name="DataInput"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnDataObject" version="0.0.9054">
        <parent fragment="Standard" name="BpmnItemAwareElement"/>
        <attribute name="IsCollection" type="java.lang.Boolean"></attribute>
      </metaclass>
      <metaclass name="BpmnDataOutput" version="0.0.9054">
        <parent fragment="Standard" name="BpmnItemAwareElement"/>
        <attribute name="IsCollection" type="java.lang.Boolean"></attribute>
        <dependency name="RepresentedParameter" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="BpmnRepresentingDataOutput"/>
        </dependency>
        <dependency name="OwnerActivity" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="OutputSpecification"/>
        </dependency>
        <dependency name="Catched" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnCatchEvent"/>
          <opposite name="DataOutput"/>
        </dependency>
        <dependency name="OwnerLoopCharacteristics" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnMultiInstanceLoopCharacteristics"/>
          <opposite name="LoopDataOutputRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnDataState" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Item" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="DataState"/>
        </dependency>
        <dependency name="UmlState" min="0" max="1" navigate="true">
          <target fragment="Standard" name="State"/>
          <opposite name="BpmnDataStateRefs"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnDataStore" version="0.0.9054">
        <parent fragment="Standard" name="BpmnItemAwareElement"/>
        <attribute name="Capacity" type="java.lang.Integer"></attribute>
        <attribute name="IsUnlimited" type="java.lang.Boolean"></attribute>
      </metaclass>
      <metaclass name="BpmnEndEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnThrowEvent"/>
      </metaclass>
      <metaclass name="BpmnEndPoint" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <dependency name="ParticipantRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="EndPointRefs"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnErrorEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <attribute name="ErrorCode" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnEscalationEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <attribute name="EscalationCode" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnEvent" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnFlowNode"/>
        <dependency name="EventDefinitions" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnEventDefinition"/>
          <opposite name="Defined"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnEventBasedGateway" version="0.0.9054">
        <parent fragment="Standard" name="BpmnGateway"/>
        <attribute name="Instanciate" type="java.lang.Boolean"></attribute>
        <attribute name="EventGatewayType" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGatewayType"></attribute>
      </metaclass>
      <metaclass name="BpmnEventDefinition" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Defined" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnEvent"/>
          <opposite name="EventDefinitions"/>
        </dependency>
        <dependency name="LoopRef" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMultiInstanceLoopCharacteristics"/>
          <opposite name="CompletionEventRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnExclusiveGateway" version="0.0.9054">
        <parent fragment="Standard" name="BpmnGateway"/>
        <dependency name="DefaultFlow" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="DefaultOfExclusive"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnFlowElement" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="TriggeredByEvent" type="java.lang.Boolean"></attribute>
        <dependency name="Groups" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnGroup"/>
          <opposite name="Categorized"/>
        </dependency>
        <dependency name="SubProcess" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnSubProcess"/>
          <opposite name="FlowElement"/>
        </dependency>
        <dependency name="Lane" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnLane"/>
          <opposite name="FlowElementRef"/>
        </dependency>
        <dependency name="Container" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="FlowElement"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnFlowNode" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnFlowElement"/>
        <dependency name="Outgoing" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="SourceRef"/>
        </dependency>
        <dependency name="Resource" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnResourceRole"/>
          <opposite name="Annotated"/>
        </dependency>
        <dependency name="Incoming" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="TargetRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnGateway" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnFlowNode"/>
        <attribute name="GatewayDirection" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.gateways.BpmnGatewayDirection"></attribute>
      </metaclass>
      <metaclass name="BpmnGroup" version="0�0  R              	  .0.9054">
        <parent fragment="Standard" name="BpmnArtifact"/>
        <attribute name="Category" type="java.lang.String"></attribute>
        <dependency name="Categorized" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnFlowElement"/>
          <opposite name="Groups"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnImplicitThrowEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnThrowEvent"/>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnComplexBehaviorDefinition"/>
          <opposite name="Event"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnInclusiveGateway" version="0.0.9054">
        <parent fragment="Standard" name="BpmnGateway"/>
        <dependency name="DefaultFlow" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="DefaultOfInclusive"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnInterface" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <dependency name="ImplementationRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="BpmnInterfaceRefs"/>
        </dependency>
        <dependency name="Operation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="BpmnInterfaceRef"/>
        </dependency>
        <dependency name="ParticipantRef" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="InterfaceRefs"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnIntermediateCatchEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnCatchEvent"/>
      </metaclass>
      <metaclass name="BpmnIntermediateThrowEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnThrowEvent"/>
      </metaclass>
      <metaclass name="BpmnItemAwareElement" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnFlowElement"/>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="BpmnItemAwareRefs"/>
        </dependency>
        <dependency name="TargetOfDataAssociation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="TargetRef"/>
        </dependency>
        <dependency name="ItemSubjectRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnItemDefinition"/>
          <opposite name="TypedItem"/>
        </dependency>
        <dependency name="InState" min="0" max="1" navigate="true">
          <target fragment="Standard" name="State"/>
          <opposite name="RequiredStateOfBpmnItem"/>
        </dependency>
        <dependency name="RepresentedAssociationEnd" min="0" max="1" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="RepresentingItem"/>
        </dependency>
        <dependency name="DataState" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataState"/>
          <opposite name="Item"/>
        </dependency>
        <dependency name="SourceOfDataAssociation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="SourceRef"/>
        </dependency>
        <dependency name="RepresentedAttribute" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="RepresentingItem"/>
        </dependency>
        <dependency name="RepresentedInstance" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="RepresentingItem"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnItemDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <attribute name="ItemKind" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.objects.BpmnItemKind"></attribute>
        <attribute name="IsCollection" type="java.lang.Boolean"></attribute>
        <dependency name="StructureRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="BpmnItemDefinitionRefs"/>
        </dependency>
        <dependency name="TypedMessage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="ItemRef"/>
        </dependency>
        <dependency name="TypedItem" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="ItemSubjectRef"/>
        </dependency>
        <dependency name="TypedResourceParameter" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnResourceParameter"/>
          <opposite name="Type"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnLane" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="ChildLaneSet" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnLaneSet"/>
          <opposite name="ParentLane"/>
        </dependency>
        <dependency name="PartitionElement" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="BpmnLaneRefs"/>
        </dependency>
        <dependency name="FlowElementRef" min="0" max="-1" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="BpmnFlowElement"/>
          <opposite name="Lane"/>
        </dependency>
        <dependency name="LaneSet" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnLaneSet"/>
          <opposite name="Lane"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnLaneSet" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Lane" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnLane"/>
          <opposite name="LaneSet"/>
        </dependency>
        <dependency name="Process" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="LaneSet"/>
        </dependency>
        <dependency name="ParentLane" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnLane"/>
          <opposite name="ChildLaneSet"/>
        </dependency>
        <dependency name="SubProcess" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnSubProcess"/>
          <opposite name="LaneSet"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnLinkEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <dependency name="Source" min="1" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnLinkEventDefinition"/>
          <opposite name="Target"/>
        </dependency>
        <dependency name="Target" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnLinkEventDefinition"/>
          <opposite name="Source"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnLoopCharacteristics" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="OwnerActivity" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="LoopCharacteristics"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnManualTask" version="0.0.9054">
        <parent f�0  R              
  ragment="Standard" name="BpmnTask"/>
      </metaclass>
      <metaclass name="BpmnMessage" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="BpmnMessageRefs"/>
        </dependency>
        <dependency name="OutputMessage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="OutMessageRef"/>
        </dependency>
        <dependency name="ItemRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnItemDefinition"/>
          <opposite name="TypedMessage"/>
        </dependency>
        <dependency name="InState" min="0" max="1" navigate="true">
          <target fragment="Standard" name="State"/>
          <opposite name="RequiredStateOfBpmnMessage"/>
        </dependency>
        <dependency name="EventDefinition" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessageEventDefinition"/>
          <opposite name="MessageRef"/>
        </dependency>
        <dependency name="Sender" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnSendTask"/>
          <opposite name="MessageRef"/>
        </dependency>
        <dependency name="InputMessage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="InMessageRef"/>
        </dependency>
        <dependency name="Receiver" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnReceiveTask"/>
          <opposite name="MessageRef"/>
        </dependency>
        <dependency name="MessageFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessageFlow"/>
          <opposite name="MessageRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnMessageEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <dependency name="MessageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="EventDefinition"/>
        </dependency>
        <dependency name="OperationRef" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="EventDefinition"/>
        </dependency>
      </metaclass>
      <link_metaclass name="BpmnMessageFlow" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="MessageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="MessageFlow"/>
        </dependency>
        <dependency name="SourceRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnBaseElement"/>
          <opposite name="OutgoingFlow"/>
        </dependency>
        <dependency name="TargetRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnBaseElement"/>
          <opposite name="IncomingFlow"/>
        </dependency>
        <dependency name="Collaboration" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnCollaboration"/>
          <opposite name="MessageFlow"/>
        </dependency>
        <sources>
          <dep name="SourceRef"/>
        </sources>
        <targets>
          <dep name="TargetRef"/>
        </targets>
      </link_metaclass>
      <metaclass name="BpmnMultiInstanceLoopCharacteristics" version="0.0.9054">
        <parent fragment="Standard" name="BpmnLoopCharacteristics"/>
        <attribute name="IsSequencial" type="java.lang.Boolean"></attribute>
        <attribute name="Behavior" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.activities.MultiInstanceBehavior"></attribute>
        <attribute name="LoopCardinality" type="java.lang.String"></attribute>
        <attribute name="CompletionCondition" type="java.lang.String"></attribute>
        <dependency name="LoopDataInput" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataInput"/>
          <opposite name="OwnerLoopCharacteristics"/>
        </dependency>
        <dependency name="LoopDataOutputRef" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataOutput"/>
          <opposite name="OwnerLoopCharacteristics"/>
        </dependency>
        <dependency name="CompletionEventRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnEventDefinition"/>
          <opposite name="LoopRef"/>
        </dependency>
        <dependency name="ComplexBehaviorDefinition" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnComplexBehaviorDefinition"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnOperation" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Sender" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnSendTask"/>
          <opposite name="OperationRef"/>
        </dependency>
        <dependency name="InMessageRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="InputMessage"/>
        </dependency>
        <dependency name="Caller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnServiceTask"/>
          <opposite name="OperationRef"/>
        </dependency>
        <dependency name="OutMessageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="OutputMessage"/>
        </dependency>
        <dependency name="EventDefinition" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessageEventDefinition"/>
          <opposite name="OperationRef"/>
        </dependency>
        <dependency name="ImplementationRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="BpmnOperationRef"/>
        </dependency>
        <dependency name="BpmnInterfaceRef" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnInterface"/>
          <opposite name="Operation"/>
        </dependency>
        <dependency name="Receiver" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnReceiveTask"/>
          <opposite name="OperationRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnParallelGateway" version="0.0.9054">
        <parent fragment="Standard" name="BpmnGateway"/>
      </metaclass>
      <metaclass name="BpmnParticipant" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="MultiplicityMin" type="java.lang.Integer"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.Integer"></attribute>
        <dependency name="Process" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Participant"/>
        </dependency>
        <dependency name="Container" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnCollaboration"/>
          <opposite name="Participants"/>
        </dependency>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="BpmnRepresents"/>
        </dependency>
        <dependency name="EndPointRefs" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnEndPoint"/>
          <opposite name="ParticipantRefs"/>
        </dependency>
        <dependency name="InterfaceRefs" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnInterface"/�0  R                >
          <opposite name="ParticipantRef"/>
        </dependency>
        <dependency name="PackageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Package"/>
          <opposite name="BpmnRepresents"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnProcess" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <attribute name="ProcessType" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.processCollaboration.BpmnProcessType"></attribute>
        <attribute name="IsClosed" type="java.lang.Boolean"></attribute>
        <attribute name="IsExecutable" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.processCollaboration.OptionalBoolean"></attribute>
        <dependency name="Caller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnCallActivity"/>
          <opposite name="CalledProcess"/>
        </dependency>
        <dependency name="Supports" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Supported"/>
        </dependency>
        <dependency name="Artifact" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnArtifact"/>
          <opposite name="Process"/>
        </dependency>
        <dependency name="LaneSet" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnLaneSet"/>
          <opposite name="Process"/>
        </dependency>
        <dependency name="Supported" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Supports"/>
        </dependency>
        <dependency name="Participant" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="Process"/>
        </dependency>
        <dependency name="FlowElement" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnFlowElement"/>
          <opposite name="Container"/>
        </dependency>
        <dependency name="Resource" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnResourceRole"/>
          <opposite name="Process"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnProcessCollaborationDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
      </metaclass>
      <metaclass name="BpmnReceiveTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
        <attribute name="Implementation" type="java.lang.String"></attribute>
        <attribute name="Instanciate" type="java.lang.Boolean"></attribute>
        <dependency name="MessageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="Receiver"/>
        </dependency>
        <dependency name="OperationRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="Receiver"/>
        </dependency>
        <dependency name="CalledOperation" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="CallerReceiveTask"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnResource" version="0.0.9054">
        <parent fragment="Standard" name="BpmnRootElement"/>
        <dependency name="ResourceroleRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnResourceRole"/>
          <opposite name="ResourceRef"/>
        </dependency>
        <dependency name="Parameter" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnResourceParameter"/>
          <opposite name="Resource"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnResourceParameter" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="IsRequired" type="java.lang.Boolean"></attribute>
        <dependency name="Resource" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnResource"/>
          <opposite name="Parameter"/>
        </dependency>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnItemDefinition"/>
          <opposite name="TypedResourceParameter"/>
        </dependency>
        <dependency name="ParameterBindingRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnResourceParameterBinding"/>
          <opposite name="ParameterRef"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnResourceParameterBinding" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <attribute name="Expression" type="java.lang.String"></attribute>
        <dependency name="ResourceRole" min="1" max="1" navigate="false">
          <target fragment="Standard" name="BpmnResourceRole"/>
          <opposite name="ResourceParameterBinding"/>
        </dependency>
        <dependency name="ParameterRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnResourceParameter"/>
          <opposite name="ParameterBindingRefs"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnResourceRole" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="ResourceRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnResource"/>
          <opposite name="ResourceroleRefs"/>
        </dependency>
        <dependency name="Annotated" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnFlowNode"/>
          <opposite name="Resource"/>
        </dependency>
        <dependency name="ResourceParameterBinding" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnResourceParameterBinding"/>
          <opposite name="ResourceRole"/>
        </dependency>
        <dependency name="Process" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnProcess"/>
          <opposite name="Resource"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnRootElement" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnBehavior"/>
          <opposite name="RootElement"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnScriptTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
        <attribute name="ScriptLanguage" type="java.lang.String"></attribute>
        <attribute name="Script" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnSendTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
        <attribute name="Implementation" type="java.lang.String"></attribute>
        <dependency name="MessageRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="Sender"/>
        </dependency>
        <dependency name="OperationRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="Sender"/>
        </dependency>
        <dependency name="CalledOperation" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="CallerSendTask"/>
        </dependency>
      </metaclass>
      <link_metaclass name="BpmnSequenceFlow" version="0.0.9054">
        <parent fragment="Standard" name="BpmnFlowElement"/>
        <attribute name="IsImmediate" type="java.lang.Boolean"></attribute>
        <attribute name="ConditionExpression" ty�0  R                pe="java.lang.String"></attribute>
        <dependency name="SourceRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnFlowNode"/>
          <opposite name="Outgoing"/>
        </dependency>
        <dependency name="TargetRef" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnFlowNode"/>
          <opposite name="Incoming"/>
        </dependency>
        <dependency name="DefaultOfInclusive" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnInclusiveGateway"/>
          <opposite name="DefaultFlow"/>
        </dependency>
        <dependency name="DefaultFrom" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnActivity"/>
          <opposite name="DefaultFlow"/>
        </dependency>
        <dependency name="DefaultOfExclusive" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnExclusiveGateway"/>
          <opposite name="DefaultFlow"/>
        </dependency>
        <dependency name="Connector" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlowDataAssociation"/>
          <opposite name="Connected"/>
        </dependency>
        <dependency name="DefaultOfComplex" min="0" max="1" navigate="false">
          <target fragment="Standard" name="BpmnComplexGateway"/>
          <opposite name="DefaultFlow"/>
        </dependency>
        <sources>
          <dep name="SourceRef"/>
        </sources>
        <targets>
          <dep name="TargetRef"/>
        </targets>
      </link_metaclass>
      <metaclass name="BpmnSequenceFlowDataAssociation" version="0.0.9054">
        <parent fragment="Standard" name="BpmnBaseElement"/>
        <dependency name="Connected" min="1" max="1" navigate="true">
          <target fragment="Standard" name="BpmnSequenceFlow"/>
          <opposite name="Connector"/>
        </dependency>
        <dependency name="DataAssociation" min="2" max="2" navigate="true">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="VisualShortCut"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnServiceTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
        <attribute name="Implementation" type="java.lang.String"></attribute>
        <dependency name="CalledOperation" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="CallerServiceTask"/>
        </dependency>
        <dependency name="OperationRef" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="Caller"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnSignalEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
      </metaclass>
      <metaclass name="BpmnStandardLoopCharacteristics" version="0.0.9054">
        <parent fragment="Standard" name="BpmnLoopCharacteristics"/>
        <attribute name="TestBefore" type="java.lang.Boolean"></attribute>
        <attribute name="LoopCondition" type="java.lang.String"></attribute>
        <attribute name="LoopMaximum" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnStartEvent" version="0.0.9054">
        <parent fragment="Standard" name="BpmnCatchEvent"/>
        <attribute name="IsInterrupting" type="java.lang.Boolean"></attribute>
      </metaclass>
      <metaclass name="BpmnSubProcess" version="0.0.9054">
        <parent fragment="Standard" name="BpmnActivity"/>
        <attribute name="TriggeredByEvent" type="java.lang.Boolean"></attribute>
        <dependency name="Artifact" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnArtifact"/>
          <opposite name="SubProcess"/>
        </dependency>
        <dependency name="FlowElement" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnFlowElement"/>
          <opposite name="SubProcess"/>
        </dependency>
        <dependency name="LaneSet" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnLaneSet"/>
          <opposite name="SubProcess"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnSubProcessDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
      </metaclass>
      <metaclass name="BpmnTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnActivity"/>
        <attribute name="IsGlobal" type="java.lang.Boolean"></attribute>
        <dependency name="Caller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnCallActivity"/>
          <opposite name="CalledGlobalTask"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnTerminateEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
      </metaclass>
      <metaclass name="BpmnThrowEvent" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="BpmnEvent"/>
        <dependency name="DataInputAssociation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataAssociation"/>
          <opposite name="StartingEvent"/>
        </dependency>
        <dependency name="DataInput" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BpmnDataInput"/>
          <opposite name="OwnerThrowEvent"/>
        </dependency>
      </metaclass>
      <metaclass name="BpmnTimerEventDefinition" version="0.0.9054">
        <parent fragment="Standard" name="BpmnEventDefinition"/>
        <attribute name="TimeCycle" type="java.lang.String"></attribute>
        <attribute name="TimeDate" type="java.lang.String"></attribute>
        <attribute name="TimeDuration" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="BpmnTransaction" version="0.0.9054">
        <parent fragment="Standard" name="BpmnSubProcess"/>
        <attribute name="Method" type="java.lang.Enum" enumType="org.modelio.metamodel.bpmn.activities.TransactionMethod"></attribute>
      </metaclass>
      <metaclass name="BpmnUserTask" version="0.0.9054">
        <parent fragment="Standard" name="BpmnTask"/>
        <attribute name="Implementation" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="CallAction" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ActivityAction"/>
        <attribute name="IsSynchronous" type="java.lang.Boolean"></attribute>
      </metaclass>
      <metaclass name="CallBehaviorAction" version="0.0.9054">
        <parent fragment="Standard" name="CallAction"/>
        <dependency name="Called" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="Caller"/>
        </dependency>
      </metaclass>
      <metaclass name="CallOperationAction" version="0.0.9054">
        <parent fragment="Standard" name="CallAction"/>
        <dependency name="Called" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="CallingAction"/>
        </dependency>
      </metaclass>
      <metaclass name="CentralBufferNode" version="0.0.9054">
        <parent fragment="Standard" name="ObjectNode"/>
      </metaclass>
      <metaclass name="ChoicePseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="Class" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
        <attribute name="IsActive" type="java.lang.Boolean"></attribute>
        <attribute name="IsMain" type="java.lang.Boolean"></attribute>
        <dependency name="LinkToAssociation" min="0" max="1" navigate="false" cascadeDelete="true">
          <�0  R                target fragment="Standard" name="ClassAssociation"/>
          <opposite name="ClassPart"/>
        </dependency>
      </metaclass>
      <metaclass name="ClassAssociation" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="NaryAssociationPart" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NaryAssociation"/>
          <opposite name="LinkToClass"/>
        </dependency>
        <dependency name="ClassPart" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Class"/>
          <opposite name="LinkToAssociation"/>
        </dependency>
        <dependency name="AssociationPart" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Association"/>
          <opposite name="LinkToClass"/>
        </dependency>
      </metaclass>
      <metaclass name="ClassDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="StaticDiagram"/>
      </metaclass>
      <metaclass name="Classifier" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="NameSpace"/>
        <dependency name="OwnedOperation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="Representation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationItem"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="Substitued" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Substitution"/>
          <opposite name="SubstitutingClassifier"/>
        </dependency>
        <dependency name="OwnedAttribute" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="OwnedNaryEnd" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="NaryAssociationEnd"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="Conveyer" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="Conveyed"/>
        </dependency>
        <dependency name="SubstitutingSubstitution" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Substitution"/>
          <opposite name="Contract"/>
        </dependency>
        <dependency name="TargetingEnd" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Target"/>
        </dependency>
        <dependency name="OwnedEnd" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Source"/>
        </dependency>
        <dependency name="BpmnRepresents" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="Throwing" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="RaisedException"/>
          <opposite name="ThrownType"/>
        </dependency>
        <dependency name="InternalStructure" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BindableInstance"/>
          <opposite name="InternalOwner"/>
        </dependency>
        <dependency name="RealizedComponent" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="ComponentRealization"/>
          <opposite name="RealizingClassifier"/>
        </dependency>
      </metaclass>
      <metaclass name="Clause" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Test" type="java.lang.String"></attribute>
        <dependency name="Body" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="OwnerClause"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ConditionalNode"/>
          <opposite name="OwnedClause"/>
        </dependency>
      </metaclass>
      <metaclass name="Collaboration" version="0.0.9054">
        <parent fragment="Standard" name="NameSpace"/>
        <attribute name="IsConcurrent" type="java.lang.Boolean"></attribute>
        <dependency name="ORepresented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Example"/>
        </dependency>
        <dependency name="BRepresented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="OwnedCollaboration"/>
        </dependency>
        <dependency name="Occurrence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CollaborationUse"/>
          <opposite name="Type"/>
        </dependency>
      </metaclass>
      <metaclass name="CollaborationUse" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Type" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Collaboration"/>
          <opposite name="Occurrence"/>
        </dependency>
        <dependency name="NRepresented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="OwnedCollaborationUse"/>
        </dependency>
        <dependency name="ORepresented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="OwnedCollaborationUse"/>
        </dependency>
        <dependency name="RoleBinding" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Binding"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="CombinedFragment" version="0.0.9054">
        <parent fragment="Standard" name="InteractionFragment"/>
        <attribute name="Operator" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperator"></attribute>
        <dependency name="Operand" min="1" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InteractionOperand"/>
          <opposite name="OwnerFragment"/>
        </dependency>
        <dependency name="FragmentGate" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Gate"/>
          <opposite name="OwnerFragment"/>
        </dependency>
      </metaclass>
      <link_metaclass name="CommunicationChannel" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="StartToEndMessage" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="CommunicationMessage"/>
          <opposite name="Channel"/>
        </dependency>
        <dependency name="Channel" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Link"/>
          <opposite name="Sent"/>
        </dependency>
        <dependency name="Start" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CommunicationNode"/>
          <opposite name="Started"/>
        </dependency>
        <dependency name="NaryChannel" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NaryLink"/>
          <opposite name="Sent"/>
        </dependency>
        <dependency name="EndToStartMessage" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="CommunicationMessage"/>
          <opposite �0  R                name="InvertedChannel"/>
        </dependency>
        <dependency name="End" min="0" max="1" navigate="true">
          <target fragment="Standard" name="CommunicationNode"/>
          <opposite name="Ended"/>
        </dependency>
        <sources>
          <dep name="Start"/>
        </sources>
        <targets>
          <dep name="End"/>
        </targets>
      </link_metaclass>
      <metaclass name="CommunicationDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
      </metaclass>
      <metaclass name="CommunicationInteraction" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <dependency name="Owned" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="CommunicationNode"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="CommunicationMessage" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Argument" type="java.lang.String"></attribute>
        <attribute name="Sequence" type="java.lang.String"></attribute>
        <attribute name="SortOfMessage" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.interactionModel.MessageSort"></attribute>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingCommunicationMessage"/>
        </dependency>
        <dependency name="Channel" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="StartToEndMessage"/>
        </dependency>
        <dependency name="InvertedChannel" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="EndToStartMessage"/>
        </dependency>
        <dependency name="Invoked" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="CommunicationUsage"/>
        </dependency>
        <dependency name="SignalSignature" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="CommunicationUsage"/>
        </dependency>
      </metaclass>
      <metaclass name="CommunicationNode" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Selector" type="java.lang.String"></attribute>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CommunicationInteraction"/>
          <opposite name="Owned"/>
        </dependency>
        <dependency name="Represented" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="RepresentedCommunicationNode"/>
        </dependency>
        <dependency name="Started" min="0" max="-1" aggregation="Composition" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="Start"/>
        </dependency>
        <dependency name="Ended" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="End"/>
        </dependency>
      </metaclass>
      <metaclass name="Component" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Class"/>
        <dependency name="Realization" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ComponentRealization"/>
          <opposite name="Abstraction"/>
        </dependency>
      </metaclass>
      <metaclass name="ComponentRealization" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="RealizingClassifier" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="RealizedComponent"/>
        </dependency>
        <dependency name="Abstraction" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Component"/>
          <opposite name="Realization"/>
        </dependency>
      </metaclass>
      <metaclass name="CompositeStructureDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="StaticDiagram"/>
      </metaclass>
      <metaclass name="ConditionalNode" version="0.0.9054">
        <parent fragment="Standard" name="StructuredActivityNode"/>
        <attribute name="IsDeterminate" type="java.lang.Boolean"></attribute>
        <attribute name="IsAssured" type="java.lang.Boolean"></attribute>
        <dependency name="OwnedClause" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Clause"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="ConnectionPointReference" version="0.0.9054">
        <parent fragment="Standard" name="StateVertex"/>
        <dependency name="Exit" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ExitPointPseudoState"/>
          <opposite name="Connection"/>
        </dependency>
        <dependency name="Entry" min="0" max="1" navigate="true">
          <target fragment="Standard" name="EntryPointPseudoState"/>
          <opposite name="Connection"/>
        </dependency>
        <dependency name="OwnerState" min="0" max="1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="Connection"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Connector" version="0.0.9054">
        <parent fragment="Standard" name="Link"/>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <link_metaclass name="ConnectorEnd" version="0.0.9054">
        <parent fragment="Standard" name="LinkEnd"/>
        <dependency name="Representation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Binding"/>
          <opposite name="ConnectorEndRole"/>
        </dependency>
        <dependency name="RepresentedFeature" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="RepresentingEnd"/>
        </dependency>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <metaclass name="Constraint" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="BaseClass" type="java.lang.String"></attribute>
        <attribute name="Body" type="java.lang.String"></attribute>
        <attribute name="Language" type="java.lang.String"></attribute>
        <dependency name="ConstrainedElement" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="ConstraintDefinition"/>
        </dependency>
      </metaclass>
      <link_metaclass name="ControlFlow" version="0.0.9054">
        <parent fragment="Standard" name="ActivityEdge"/>
        <sources>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="ControlNode" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ActivityNode"/>
      </metaclass>
      <link_metaclass name="DataFlow" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Destination" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Received"/>
        </dependency>
        <dependency name="Origin" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Sent"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Na� 0  R                meSpace"/>
          <opposite name="OwnedDataFlow"/>
        </dependency>
        <dependency name="SModel" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="DOccurence"/>
        </dependency>
        <sources>
          <dep name="Origin"/>
        </sources>
        <targets>
          <dep name="Destination"/>
        </targets>
      </link_metaclass>
      <metaclass name="DataStoreNode" version="0.0.9054">
        <parent fragment="Standard" name="CentralBufferNode"/>
      </metaclass>
      <metaclass name="DataType" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
      </metaclass>
      <metaclass name="DecisionMergeNode" version="0.0.9054">
        <parent fragment="Standard" name="ControlNode"/>
        <attribute name="DecisionKind" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.activityModel.DecisionNodeKind"></attribute>
        <attribute name="DecisionInputBehavior" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="DeepHistoryPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="DeploymentDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="StaticDiagram"/>
      </metaclass>
      <metaclass name="DurationConstraint" version="0.0.9054">
        <parent fragment="Standard" name="Constraint"/>
        <attribute name="DurationMin" type="java.lang.String"></attribute>
        <attribute name="DurationMax" type="java.lang.String"></attribute>
      </metaclass>
      <link_metaclass name="ElementImport" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Visibility" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.VisibilityMode"></attribute>
        <dependency name="ImportingNameSpace" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="OwnedImport"/>
        </dependency>
        <dependency name="ImportedElement" min="1" max="1" navigate="true">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Importing"/>
        </dependency>
        <dependency name="ImportingOperation" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="OwnedImport"/>
        </dependency>
        <sources>
          <dep name="ImportingNameSpace"/>
          <dep name="ImportingOperation"/>
        </sources>
        <targets>
          <dep name="ImportedElement"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="ElementRealization" version="0.0.9054">
        <parent fragment="Standard" name="Abstraction"/>
        <sources>
          <dep name="Impacted"/>
        </sources>
        <targets>
          <dep name="DependsOn"/>
        </targets>
      </link_metaclass>
      <metaclass name="EntryPointPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
        <dependency name="EntryOf" min="0" max="1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="EntryPoint"/>
        </dependency>
        <dependency name="Connection" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ConnectionPointReference"/>
          <opposite name="Entry"/>
        </dependency>
        <dependency name="EntryOfMachine" min="0" max="1" navigate="false">
          <target fragment="Standard" name="StateMachine"/>
          <opposite name="EntryPoint"/>
        </dependency>
      </metaclass>
      <metaclass name="Enumeration" version="0.0.9054">
        <parent fragment="Standard" name="GeneralClass"/>
        <dependency name="Value" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="EnumerationLiteral"/>
          <opposite name="Valuated"/>
        </dependency>
      </metaclass>
      <metaclass name="EnumerationLiteral" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Valuated" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Enumeration"/>
          <opposite name="Value"/>
        </dependency>
      </metaclass>
      <metaclass name="Event" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Expression" type="java.lang.String"></attribute>
        <attribute name="Kind" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.commonBehaviors.EventType"></attribute>
        <dependency name="Triggered" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Transition"/>
          <opposite name="Trigger"/>
        </dependency>
        <dependency name="Model" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="EOccurence"/>
        </dependency>
        <dependency name="Origin" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="Deffered"/>
        </dependency>
        <dependency name="Called" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Occurence"/>
        </dependency>
        <dependency name="Composed" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="EComponent"/>
        </dependency>
      </metaclass>
      <metaclass name="ExceptionHandler" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Guard" type="java.lang.String"></attribute>
        <attribute name="Weight" type="java.lang.String"></attribute>
        <dependency name="ProtectedNode" min="1" max="1" navigate="false">
          <target fragment="Standard" name="ActivityAction"/>
          <opposite name="Handler"/>
        </dependency>
        <dependency name="ExceptionInput" min="1" max="1" navigate="true">
          <target fragment="Standard" name="InputPin"/>
          <opposite name="Handler"/>
        </dependency>
        <dependency name="ExceptionType" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="ExceptionInput"/>
        </dependency>
      </metaclass>
      <metaclass name="ExecutionOccurenceSpecification" version="0.0.9054">
        <parent fragment="Standard" name="MessageEnd"/>
        <dependency name="Finished" min="0" max="1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="ExecutionSpecification"/>
          <opposite name="Finish"/>
        </dependency>
        <dependency name="Started" min="0" max="1" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="ExecutionSpecification"/>
          <opposite name="Start"/>
        </dependency>
      </metaclass>
      <metaclass name="ExecutionSpecification" version="0.0.9054">
        <parent fragment="Standard" name="InteractionFragment"/>
        <dependency name="Finish" min="1" max="1" navigate="true">
          <target fragment="Standard" name="ExecutionOccurenceSpecification"/>
          <opposite name="Finished"/>
        </dependency>
        <dependency name="Start" min="1" max="1" navigate="false">
          <target fragment="Standard" name="ExecutionOccurenceSpecification"/>
          <opposite name="Started"/>
        </dependency>
      </metaclass>
      <metaclass name="ExitPointPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
        <dependency name="ExitOf" min="0" max="1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="ExitPoint"/>
        </dependency>
        <dependency name="Connection" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Conne� 0  R                ctionPointReference"/>
          <opposite name="Exit"/>
        </dependency>
        <dependency name="ExitOfMachine" min="0" max="1" navigate="false">
          <target fragment="Standard" name="StateMachine"/>
          <opposite name="ExitPoint"/>
        </dependency>
      </metaclass>
      <metaclass name="ExpansionNode" version="0.0.9054">
        <parent fragment="Standard" name="ObjectNode"/>
        <dependency name="RegionAsOutput" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ExpansionRegion"/>
          <opposite name="OutputElement"/>
        </dependency>
        <dependency name="RegionAsInput" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ExpansionRegion"/>
          <opposite name="InputElement"/>
        </dependency>
      </metaclass>
      <metaclass name="ExpansionRegion" version="0.0.9054">
        <parent fragment="Standard" name="StructuredActivityNode"/>
        <attribute name="Mode" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.activityModel.ExpansionKind"></attribute>
        <dependency name="OutputElement" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExpansionNode"/>
          <opposite name="RegionAsOutput"/>
        </dependency>
        <dependency name="InputElement" min="1" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExpansionNode"/>
          <opposite name="RegionAsInput"/>
        </dependency>
      </metaclass>
      <metaclass name="ExtensionPoint" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Visibility" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.VisibilityMode"></attribute>
        <dependency name="Extended" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="UseCaseDependency"/>
          <opposite name="ExtensionLocation"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="UseCase"/>
          <opposite name="OwnedExtension"/>
        </dependency>
      </metaclass>
      <metaclass name="Feature" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Visibility" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.VisibilityMode"></attribute>
        <attribute name="IsClass" type="java.lang.Boolean"></attribute>
        <attribute name="IsAbstract" type="java.lang.Boolean"></attribute>
      </metaclass>
      <metaclass name="FinalNode" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ControlNode"/>
      </metaclass>
      <metaclass name="FinalState" version="0.0.9054">
        <parent fragment="Standard" name="State"/>
      </metaclass>
      <metaclass name="FlowFinalNode" version="0.0.9054">
        <parent fragment="Standard" name="FinalNode"/>
      </metaclass>
      <metaclass name="ForkJoinNode" version="0.0.9054">
        <parent fragment="Standard" name="ControlNode"/>
        <attribute name="IsCombineDuplicate" type="java.lang.Boolean"></attribute>
        <attribute name="JoinSpec" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="ForkPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="Gate" version="0.0.9054">
        <parent fragment="Standard" name="MessageEnd"/>
        <dependency name="OwnerUse" min="0" max="1" navigate="false">
          <target fragment="Standard" name="InteractionUse"/>
          <opposite name="ActualGate"/>
        </dependency>
        <dependency name="Actual" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Gate"/>
          <opposite name="Formal"/>
        </dependency>
        <dependency name="OwnerInteraction" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Interaction"/>
          <opposite name="FormalGate"/>
        </dependency>
        <dependency name="OwnerFragment" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CombinedFragment"/>
          <opposite name="FragmentGate"/>
        </dependency>
        <dependency name="Formal" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Gate"/>
          <opposite name="Actual"/>
        </dependency>
      </metaclass>
      <metaclass name="GeneralClass" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="Classifier"/>
        <attribute name="IsElementary" type="java.lang.Boolean"></attribute>
        <dependency name="BpmnInterfaceRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnInterface"/>
          <opposite name="ImplementationRef"/>
        </dependency>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="ExceptionInput" min="1" max="1" navigate="false">
          <target fragment="Standard" name="ExceptionHandler"/>
          <opposite name="ExceptionType"/>
        </dependency>
        <dependency name="Object" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="BpmnMessageRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="SRepresentation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Signal"/>
          <opposite name="Base"/>
        </dependency>
        <dependency name="BpmnItemDefinitionRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemDefinition"/>
          <opposite name="StructureRef"/>
        </dependency>
        <dependency name="OccurenceObjectNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="BpmnItemAwareRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="Type"/>
        </dependency>
      </metaclass>
      <metaclass name="GeneralOrdering" version="0.0.9054">
        <parent fragment="Infrastructure" name="Element"/>
        <dependency name="Before" min="1" max="1" navigate="false">
          <target fragment="Standard" name="OccurrenceSpecification"/>
          <opposite name="ToAfter"/>
        </dependency>
        <dependency name="After" min="1" max="1" navigate="true">
          <target fragment="Standard" name="OccurrenceSpecification"/>
          <opposite name="ToBefore"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Generalization" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Discriminator" type="java.lang.String"></attribute>
        <dependency name="SuperType" min="1" max="1" navigate="true">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Specialization"/>
        </dependency>
        <dependency name="SubType" min="1" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Parent"/>
        </dependency>
        <sources>
          <dep name="SubType"/>
        </sources>
        <targets>
          <dep name="SuperType"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="InformationFlow" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="OwnedInformationFlow"/� 0  R                >
        </dependency>
        <dependency name="InformationSource" min="1" max="-1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="SentInfo"/>
        </dependency>
        <dependency name="InformationTarget" min="1" max="-1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="ReceivedInfo"/>
        </dependency>
        <dependency name="RealizingActivityEdge" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="ActivityEdge"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="RealizingCommunicationMessage" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="CommunicationMessage"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="RealizingFeature" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="StructuralFeature"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="RealizingLink" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="RealizingMessage" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Message"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="RealizingNaryLink" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="NaryLink"/>
          <opposite name="RealizedInformationFlow"/>
        </dependency>
        <dependency name="Conveyed" min="1" max="-1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="Conveyer"/>
        </dependency>
        <dependency name="Channel" min="0" max="1" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Sent"/>
        </dependency>
        <sources>
          <dep name="InformationSource"/>
        </sources>
        <targets>
          <dep name="InformationTarget"/>
        </targets>
      </link_metaclass>
      <metaclass name="InformationItem" version="0.0.9054">
        <parent fragment="Standard" name="Classifier"/>
        <dependency name="Represented" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="Representation"/>
        </dependency>
      </metaclass>
      <metaclass name="InitialNode" version="0.0.9054">
        <parent fragment="Standard" name="ControlNode"/>
      </metaclass>
      <metaclass name="InitialPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="InputPin" version="0.0.9054">
        <parent fragment="Standard" name="Pin"/>
        <attribute name="IsSelf" type="java.lang.Boolean"></attribute>
        <dependency name="Handler" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="ExceptionHandler"/>
          <opposite name="ExceptionInput"/>
        </dependency>
        <dependency name="Inputing" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityAction"/>
          <opposite name="Input"/>
        </dependency>
      </metaclass>
      <metaclass name="Instance" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="IsConstant" type="java.lang.Boolean"></attribute>
        <attribute name="MultiplicityMin" type="java.lang.String"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.String"></attribute>
        <attribute name="Value" type="java.lang.String"></attribute>
        <dependency name="RepresentedCommunicationNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CommunicationNode"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="RepresentingItem" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="RepresentedInstance"/>
        </dependency>
        <dependency name="OwnedEnd" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Source"/>
        </dependency>
        <dependency name="Base" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Representing"/>
        </dependency>
        <dependency name="RepresentingObjectNode" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Declared"/>
        </dependency>
        <dependency name="OwnedNaryEnd" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="NaryLinkEnd"/>
          <opposite name="Source"/>
        </dependency>
        <dependency name="RepresentedLifeLine" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Lifeline"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="Slot" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="AttributeLink"/>
          <opposite name="Attributed"/>
        </dependency>
        <dependency name="Part" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="BindableInstance"/>
          <opposite name="Cluster"/>
        </dependency>
        <dependency name="TargetingEnd" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Target"/>
        </dependency>
      </metaclass>
      <metaclass name="InstanceNode" version="0.0.9054">
        <parent fragment="Standard" name="ObjectNode"/>
      </metaclass>
      <metaclass name="Interaction" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <dependency name="FormalGate" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Gate"/>
          <opposite name="OwnerInteraction"/>
        </dependency>
        <dependency name="Fragment" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InteractionFragment"/>
          <opposite name="EnclosingInteraction"/>
        </dependency>
        <dependency name="OwnedLine" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Lifeline"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="ReferedUse" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InteractionUse"/>
          <opposite name="RefersTo"/>
        </dependency>
      </metaclass>
      <metaclass name="InteractionFragment" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="LineNumber" type="java.lang.Integer"></attribute>
        <dependency name="EnclosingOperand" min="0" max="1" navigate="false">
          <target fragment="Standard" name="InteractionOperand"/>
          <opposite name="Fragment"/>
        </dependency>
        <dependency name="EnclosingInteraction" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Interaction"/>
          <opposite name="Fragment"/>
        </dependency>
        <dependency name="Covered" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Lifeline"/>
          <opposite name="CoveredBy"/>
        </dependency>
      </metaclass>
    � 0  R                  <metaclass name="InteractionOperand" version="0.0.9054">
        <parent fragment="Standard" name="InteractionFragment"/>
        <attribute name="Guard" type="java.lang.String"></attribute>
        <attribute name="EndLineNumber" type="java.lang.Integer"></attribute>
        <dependency name="Fragment" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InteractionFragment"/>
          <opposite name="EnclosingOperand"/>
        </dependency>
        <dependency name="OwnerFragment" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CombinedFragment"/>
          <opposite name="Operand"/>
        </dependency>
      </metaclass>
      <metaclass name="InteractionUse" version="0.0.9054">
        <parent fragment="Standard" name="InteractionFragment"/>
        <attribute name="EndLineNumber" type="java.lang.Integer"></attribute>
        <dependency name="ActualGate" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Gate"/>
          <opposite name="OwnerUse"/>
        </dependency>
        <dependency name="RefersTo" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Interaction"/>
          <opposite name="ReferedUse"/>
        </dependency>
      </metaclass>
      <metaclass name="Interface" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
        <dependency name="Requiring" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="RequiredInterface"/>
          <opposite name="RequiredElement"/>
        </dependency>
        <dependency name="ImplementedLink" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="InterfaceRealization"/>
          <opposite name="Implemented"/>
        </dependency>
        <dependency name="Providing" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ProvidedInterface"/>
          <opposite name="ProvidedElement"/>
        </dependency>
      </metaclass>
      <link_metaclass name="InterfaceRealization" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Implemented" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Interface"/>
          <opposite name="ImplementedLink"/>
        </dependency>
        <dependency name="Implementer" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Realized"/>
        </dependency>
        <sources>
          <dep name="Implementer"/>
        </sources>
        <targets>
          <dep name="Implemented"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="InternalTransition" version="0.0.9054">
        <parent fragment="Standard" name="Transition"/>
        <dependency name="SComposed" min="0" max="1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="Internal"/>
        </dependency>
        <sources>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="InterruptibleActivityRegion" version="0.0.9054">
        <parent fragment="Standard" name="ActivityGroup"/>
        <dependency name="InterruptingEdge" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="ActivityEdge"/>
          <opposite name="Interrupts"/>
        </dependency>
      </metaclass>
      <metaclass name="JoinPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="JunctionPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="Lifeline" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Selector" type="java.lang.String"></attribute>
        <dependency name="CoveredBy" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InteractionFragment"/>
          <opposite name="Covered"/>
        </dependency>
        <dependency name="DecomposedAs" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="PartDecomposition"/>
          <opposite name="Decomposed"/>
        </dependency>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Interaction"/>
          <opposite name="OwnedLine"/>
        </dependency>
        <dependency name="Represented" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="RepresentedLifeLine"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Link" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Model" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Association"/>
          <opposite name="Occurence"/>
        </dependency>
        <dependency name="LinkEnd" min="2" max="2" navigate="false">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Link"/>
        </dependency>
        <dependency name="Sent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="Channel"/>
        </dependency>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <link_metaclass name="LinkEnd" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="IsOrdered" type="java.lang.Boolean"></attribute>
        <attribute name="IsUnique" type="java.lang.Boolean"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.String"></attribute>
        <attribute name="MultiplicityMin" type="java.lang.String"></attribute>
        <dependency name="Link" min="0" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="Link"/>
          <opposite name="LinkEnd"/>
        </dependency>
        <dependency name="Target" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="TargetingEnd"/>
        </dependency>
        <dependency name="OppositeOwner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Opposite"/>
        </dependency>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingLink"/>
        </dependency>
        <dependency name="Model" min="0" max="1" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="Occurence"/>
        </dependency>
        <dependency name="Consumer" min="0" max="1" navigate="true">
          <target fragment="Standard" name="RequiredInterface"/>
          <opposite name="Provider"/>
        </dependency>
        <dependency name="Opposite" min="1" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="OppositeOwner"/>
        </dependency>
        <dependency name="Source" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="OwnedEnd"/>
        </dependency>
        <dependency name="Provider" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ProvidedInterface"/>
          <opposite name="Consumer"/>
        </dependency>
        <sources></sources>
        <targets></targets>
      </link_metaclass>
      <metaclass name="LoopNode" version="0.0.9054">
        <parent fragment="Standard" name="StructuredActivityNode"/>
        <attribute name="IsTestedFirst" type="java.lang.Boolean"></attribute>
� 0  R                        <attribute name="Setup" type="java.lang.String"></attribute>
        <attribute name="Test" type="java.lang.String"></attribute>
      </metaclass>
      <link_metaclass name="Manifestation" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="UtilizedElement" min="1" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="Manifesting"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Artifact"/>
          <opposite name="Utilized"/>
        </dependency>
        <sources>
          <dep name="Owner"/>
        </sources>
        <targets>
          <dep name="UtilizedElement"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="Message" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Argument" type="java.lang.String"></attribute>
        <attribute name="KindOfMessage" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.interactionModel.MessageKind"></attribute>
        <attribute name="SortOfMessage" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.interactionModel.MessageSort"></attribute>
        <dependency name="SignalSignature" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="Usage"/>
        </dependency>
        <dependency name="ReceiveEvent" min="0" max="1" navigate="true">
          <target fragment="Standard" name="MessageEnd"/>
          <opposite name="ReceivedMessage"/>
        </dependency>
        <dependency name="SendEvent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="MessageEnd"/>
          <opposite name="SentMessage"/>
        </dependency>
        <dependency name="Invoked" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Usage"/>
        </dependency>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingMessage"/>
        </dependency>
        <sources>
          <dep name="SendEvent"/>
        </sources>
        <targets>
          <dep name="ReceiveEvent"/>
        </targets>
      </link_metaclass>
      <metaclass name="MessageEnd" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="OccurrenceSpecification"/>
        <dependency name="ReceivedMessage" min="0" max="1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="Message"/>
          <opposite name="ReceiveEvent"/>
        </dependency>
        <dependency name="SentMessage" min="0" max="1" aggregation="Composition" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="Message"/>
          <opposite name="SendEvent"/>
        </dependency>
      </metaclass>
      <link_metaclass name="MessageFlow" version="0.0.9054">
        <parent fragment="Standard" name="ActivityEdge"/>
        <dependency name="TargetPartition" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="Incoming"/>
        </dependency>
        <dependency name="SourcePartition" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="Outgoing"/>
        </dependency>
        <sources>
          <dep name="SourcePartition"/>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="TargetPartition"/>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="ModelTree" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Owner" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ModelTree"/>
          <opposite name="OwnedElement"/>
        </dependency>
        <dependency name="OwnedElement" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ModelTree"/>
          <opposite name="Owner"/>
        </dependency>
      </metaclass>
      <metaclass name="NameSpace" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ModelTree"/>
        <attribute name="IsAbstract" type="java.lang.Boolean"></attribute>
        <attribute name="IsLeaf" type="java.lang.Boolean"></attribute>
        <attribute name="IsRoot" type="java.lang.Boolean"></attribute>
        <attribute name="Visibility" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.VisibilityMode"></attribute>
        <dependency name="Parent" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Generalization"/>
          <opposite name="SubType"/>
        </dependency>
        <dependency name="TemplateInstanciation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="TemplateBinding"/>
          <opposite name="BoundElement"/>
        </dependency>
        <dependency name="Representing" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Instance"/>
          <opposite name="Base"/>
        </dependency>
        <dependency name="OwnedBehavior" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="Received" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="DataFlow"/>
          <opposite name="Destination"/>
        </dependency>
        <dependency name="OwnedInformationFlow" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="Importing" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="ElementImport"/>
          <opposite name="ImportedElement"/>
        </dependency>
        <dependency name="Sent" min="0" max="-1" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="DataFlow"/>
          <opposite name="Origin"/>
        </dependency>
        <dependency name="OwnedDataFlow" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="DataFlow"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="OwnedCollaborationUse" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="CollaborationUse"/>
          <opposite name="NRepresented"/>
        </dependency>
        <dependency name="OwnedPackageImport" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="PackageImport"/>
          <opposite name="ImportingNameSpace"/>
        </dependency>
        <dependency name="Template" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="Parameterized"/>
        </dependency>
        <dependency name="Specialization" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="Generalization"/>
          <opposite name="SuperType"/>
        </dependency>
        <dependency name="Realized" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InterfaceRealization"/>
          <opposite name="Implementer"/>
        </dependency>
        <dependency name="Declared" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="InstanciatingBind� 0  R                ing" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="TemplateBinding"/>
          <opposite name="InstanciatedTemplate"/>
        </dependency>
        <dependency name="OwnedImport" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ElementImport"/>
          <opposite name="ImportingNameSpace"/>
        </dependency>
      </metaclass>
      <metaclass name="NaryAssociation" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="NaryLink"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="NaryEnd" min="0" max="-1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="NaryAssociationEnd"/>
          <opposite name="NaryAssociation"/>
        </dependency>
        <dependency name="LinkToClass" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ClassAssociation"/>
          <opposite name="NaryAssociationPart"/>
        </dependency>
      </metaclass>
      <metaclass name="NaryAssociationEnd" version="0.0.9054">
        <parent fragment="Standard" name="StructuralFeature"/>
        <dependency name="NaryAssociation" min="1" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="NaryAssociation"/>
          <opposite name="NaryEnd"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="OwnedNaryEnd"/>
        </dependency>
      </metaclass>
      <metaclass name="NaryConnector" version="0.0.9054">
        <parent fragment="Standard" name="NaryLink"/>
        <dependency name="Representation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Binding"/>
          <opposite name="ConnectorRole"/>
        </dependency>
        <dependency name="RepresentedFeature" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="RepresentingConnector"/>
        </dependency>
      </metaclass>
      <metaclass name="NaryConnectorEnd" version="0.0.9054">
        <parent fragment="Standard" name="NaryLinkEnd"/>
      </metaclass>
      <metaclass name="NaryLink" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="NaryLinkEnd" min="0" max="-1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="NaryLinkEnd"/>
          <opposite name="NaryLink"/>
        </dependency>
        <dependency name="Model" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NaryAssociation"/>
          <opposite name="Occurence"/>
        </dependency>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingNaryLink"/>
        </dependency>
        <dependency name="Sent" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CommunicationChannel"/>
          <opposite name="NaryChannel"/>
        </dependency>
      </metaclass>
      <metaclass name="NaryLinkEnd" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="IsOrdered" type="java.lang.Boolean"></attribute>
        <attribute name="IsUnique" type="java.lang.Boolean"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.String"></attribute>
        <attribute name="MultiplicityMin" type="java.lang.String"></attribute>
        <dependency name="Source" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Instance"/>
          <opposite name="OwnedNaryEnd"/>
        </dependency>
        <dependency name="NaryLink" min="0" max="1" aggregation="SharedAggregation" navigate="true">
          <target fragment="Standard" name="NaryLink"/>
          <opposite name="NaryLinkEnd"/>
        </dependency>
        <dependency name="Consumer" min="0" max="1" navigate="true">
          <target fragment="Standard" name="RequiredInterface"/>
          <opposite name="NaryProvider"/>
        </dependency>
        <dependency name="Provider" min="0" max="1" navigate="true">
          <target fragment="Standard" name="ProvidedInterface"/>
          <opposite name="NaryConsumer"/>
        </dependency>
      </metaclass>
      <metaclass name="Node" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Classifier"/>
        <dependency name="Resident" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Artifact"/>
          <opposite name="DeploymentLocation"/>
        </dependency>
      </metaclass>
      <metaclass name="ObjectDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="StaticDiagram"/>
      </metaclass>
      <link_metaclass name="ObjectFlow" version="0.0.9054">
        <parent fragment="Standard" name="ActivityEdge"/>
        <attribute name="TransformationBehavior" type="java.lang.String"></attribute>
        <attribute name="SelectionBehavior" type="java.lang.String"></attribute>
        <attribute name="IsMultiCast" type="java.lang.Boolean"></attribute>
        <attribute name="IsMultiReceive" type="java.lang.Boolean"></attribute>
        <attribute name="Effect" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.activityModel.ObjectFlowEffectKind"></attribute>
        <sources>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="ObjectNode" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ActivityNode"/>
        <attribute name="IsControlType" type="java.lang.Boolean"></attribute>
        <attribute name="Ordering" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.activityModel.ObjectNodeOrderingKind"></attribute>
        <attribute name="SelectionBehavior" type="java.lang.String"></attribute>
        <attribute name="UpperBound" type="java.lang.String"></attribute>
        <dependency name="Represented" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Instance"/>
          <opposite name="RepresentingObjectNode"/>
        </dependency>
        <dependency name="RepresentedRealParameter" min="0" max="1" navigate="true">
          <target fragment="Standard" name="BehaviorParameter"/>
          <opposite name="RepresentingObjectNode"/>
        </dependency>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="OccurenceObjectNode"/>
        </dependency>
        <dependency name="RepresentedRole" min="0" max="1" navigate="true">
          <target fragment="Standard" name="AssociationEnd"/>
          <opposite name="RepresentingObjectNode"/>
        </dependency>
        <dependency name="RepresentedAttribute" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Attribute"/>
          <opposite name="RepresentingObjectNode"/>
        </dependency>
        <dependency name="InState" min="0" max="1" navigate="true">
          <target fragment="Standard" name="State"/>
          <opposite name="RequiredStateOf"/>
        </dependency>
      </metaclass>
      <metaclass name="OccurrenceSpecification" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="InteractionFragment"/>
        <dependency name="ToAfter" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="GeneralOrdering"/>
          <opposite name="Before"/>
        </dependency>
        <dependency name="ToBefore" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="� 0  R                GeneralOrdering"/>
          <opposite name="After"/>
        </dependency>
      </metaclass>
      <metaclass name="OpaqueAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <attribute name="Body" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="OpaqueBehavior" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <attribute name="Body" type="java.lang.String"></attribute>
      </metaclass>
      <metaclass name="Operation" version="0.0.9054">
        <parent fragment="Standard" name="BehavioralFeature"/>
        <attribute name="Concurrency" type="java.lang.Boolean"></attribute>
        <attribute name="Final" type="java.lang.Boolean"></attribute>
        <attribute name="Passing" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.MethodPassingMode"></attribute>
        <dependency name="OwnedImport" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ElementImport"/>
          <opposite name="ImportingOperation"/>
        </dependency>
        <dependency name="Thrown" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="RaisedException"/>
          <opposite name="Thrower"/>
        </dependency>
        <dependency name="CallerReceiveTask" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnReceiveTask"/>
          <opposite name="CalledOperation"/>
        </dependency>
        <dependency name="Redefinition" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Redefines"/>
        </dependency>
        <dependency name="Example" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Collaboration"/>
          <opposite name="ORepresented"/>
        </dependency>
        <dependency name="SRepresentation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Signal"/>
          <opposite name="OBase"/>
        </dependency>
        <dependency name="OwnedBehavior" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="OwnerOperation"/>
        </dependency>
        <dependency name="BpmnOperationRef" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnOperation"/>
          <opposite name="ImplementationRef"/>
        </dependency>
        <dependency name="CallerSendTask" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnSendTask"/>
          <opposite name="CalledOperation"/>
        </dependency>
        <dependency name="IO" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="Composed"/>
        </dependency>
        <dependency name="TemplateInstanciation" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="TemplateBinding"/>
          <opposite name="BoundOperation"/>
        </dependency>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="OwnedOperation"/>
        </dependency>
        <dependency name="OwnedPackageImport" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="PackageImport"/>
          <opposite name="ImportingOperation"/>
        </dependency>
        <dependency name="Return" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="Returned"/>
        </dependency>
        <dependency name="InstanciatingBinding" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="TemplateBinding"/>
          <opposite name="InstanciatedTemplateOperation"/>
        </dependency>
        <dependency name="Usage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Message"/>
          <opposite name="Invoked"/>
        </dependency>
        <dependency name="Template" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="ParameterizedOperation"/>
        </dependency>
        <dependency name="CallerServiceTask" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnServiceTask"/>
          <opposite name="CalledOperation"/>
        </dependency>
        <dependency name="Occurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Event"/>
          <opposite name="Called"/>
        </dependency>
        <dependency name="Invoker" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Transition"/>
          <opposite name="Processed"/>
        </dependency>
        <dependency name="CommunicationUsage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CommunicationMessage"/>
          <opposite name="Invoked"/>
        </dependency>
        <dependency name="OwnedCollaborationUse" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="CollaborationUse"/>
          <opposite name="ORepresented"/>
        </dependency>
        <dependency name="Redefines" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Redefinition"/>
        </dependency>
        <dependency name="Caller" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnCallActivity"/>
          <opposite name="CalledOperation"/>
        </dependency>
        <dependency name="CallingAction" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CallOperationAction"/>
          <opposite name="Called"/>
        </dependency>
        <dependency name="EntryPointAction" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="AcceptCallEventAction"/>
          <opposite name="Called"/>
        </dependency>
      </metaclass>
      <metaclass name="OutputPin" version="0.0.9054">
        <parent fragment="Standard" name="Pin"/>
        <dependency name="Outputing" min="0" max="1" navigate="false">
          <target fragment="Standard" name="ActivityAction"/>
          <opposite name="Output"/>
        </dependency>
      </metaclass>
      <metaclass name="Package" version="1.1.01" cmsNode="true">
        <parent fragment="Standard" name="NameSpace"/>
        <attribute name="IsInstantiable" type="java.lang.Boolean"></attribute>
        <dependency name="BpmnRepresents" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnParticipant"/>
          <opposite name="PackageRef"/>
        </dependency>
        <dependency name="ReceivingMerge" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="PackageMerge"/>
          <opposite name="MergedPackage"/>
        </dependency>
        <dependency name="Represented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Project"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="Merge" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="PackageMerge"/>
          <opposite name="ReceivingPackage"/>
        </dependency>
        <dependency name="PackageImporting" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="PackageImport"/>
          <opposite name="ImportedPackage"/>
        </dependency>
      </metaclass>
      <link_metaclass name="PackageImport" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Visibility" type="java.lang.Enum" enumType="org.modelio.meta� 0  R                model.uml.statik.VisibilityMode"></attribute>
        <dependency name="ImportingOperation" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="OwnedPackageImport"/>
        </dependency>
        <dependency name="ImportingNameSpace" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="OwnedPackageImport"/>
        </dependency>
        <dependency name="ImportedPackage" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Package"/>
          <opposite name="PackageImporting"/>
        </dependency>
        <sources>
          <dep name="ImportingOperation"/>
          <dep name="ImportingNameSpace"/>
        </sources>
        <targets>
          <dep name="ImportedPackage"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="PackageMerge" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="MergedPackage" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Package"/>
          <opposite name="ReceivingMerge"/>
        </dependency>
        <dependency name="ReceivingPackage" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Package"/>
          <opposite name="Merge"/>
        </dependency>
        <sources>
          <dep name="ReceivingPackage"/>
        </sources>
        <targets>
          <dep name="MergedPackage"/>
        </targets>
      </link_metaclass>
      <metaclass name="Parameter" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="ParameterPassing" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.PassingMode"></attribute>
        <attribute name="MultiplicityMin" type="java.lang.String"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.String"></attribute>
        <attribute name="TypeConstraint" type="java.lang.String"></attribute>
        <attribute name="DefaultValue" type="java.lang.String"></attribute>
        <attribute name="IsOrdered" type="java.lang.Boolean"></attribute>
        <attribute name="IsUnique" type="java.lang.Boolean"></attribute>
        <attribute name="IsException" type="java.lang.Boolean"></attribute>
        <attribute name="IsStream" type="java.lang.Boolean"></attribute>
        <attribute name="Effect" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind"></attribute>
        <dependency name="BpmnRepresentingDataInput" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnDataInput"/>
          <opposite name="RepresentedParameter"/>
        </dependency>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="Occurence"/>
        </dependency>
        <dependency name="Composed" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="IO"/>
        </dependency>
        <dependency name="Matching" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="Pin"/>
          <opposite name="Matched"/>
        </dependency>
        <dependency name="BpmnRepresentingDataOutput" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnDataOutput"/>
          <opposite name="RepresentedParameter"/>
        </dependency>
        <dependency name="SRepresentation" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Signal"/>
          <opposite name="PBase"/>
        </dependency>
        <dependency name="Returned" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Return"/>
        </dependency>
        <dependency name="BehaviorParam" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="BehaviorParameter"/>
          <opposite name="Mapped"/>
        </dependency>
      </metaclass>
      <metaclass name="PartDecomposition" version="0.0.9054">
        <parent fragment="Standard" name="InteractionUse"/>
        <dependency name="Decomposed" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Lifeline"/>
          <opposite name="DecomposedAs"/>
        </dependency>
      </metaclass>
      <metaclass name="Pin" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="ObjectNode"/>
        <attribute name="IsControl" type="java.lang.Boolean"></attribute>
        <attribute name="IsExpansion" type="java.lang.Boolean"></attribute>
        <dependency name="Matched" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="Matching"/>
        </dependency>
      </metaclass>
      <metaclass name="Port" version="0.0.9054">
        <parent fragment="Standard" name="BindableInstance"/>
        <attribute name="IsBehavior" type="java.lang.Boolean"></attribute>
        <attribute name="IsService" type="java.lang.Boolean"></attribute>
        <attribute name="IsConjugated" type="java.lang.Boolean"></attribute>
        <attribute name="Direction" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.PortOrientation"></attribute>
        <dependency name="Provided" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ProvidedInterface"/>
          <opposite name="Providing"/>
        </dependency>
        <dependency name="Required" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="RequiredInterface"/>
          <opposite name="Requiring"/>
        </dependency>
      </metaclass>
      <metaclass name="Project" version="1.1.01" cmsNode="true">
        <parent fragment="Infrastructure" name="AbstractProject"/>
        <attribute name="ProjectContext" type="java.lang.String"></attribute>
        <attribute name="ProjectDescr" type="java.lang.String"></attribute>
        <dependency name="Model" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Package"/>
          <opposite name="Represented"/>
        </dependency>
      </metaclass>
      <metaclass name="ProvidedInterface" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="ProvidedElement" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Interface"/>
          <opposite name="Providing"/>
        </dependency>
        <dependency name="Providing" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Port"/>
          <opposite name="Provided"/>
        </dependency>
        <dependency name="Consumer" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Provider"/>
        </dependency>
        <dependency name="NaryConsumer" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="NaryLinkEnd"/>
          <opposite name="Provider"/>
        </dependency>
      </metaclass>
      <link_metaclass name="RaisedException" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="ThrownType" min="1" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="Throwing"/>
        </dependency>
        <dependency name="Thrower" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Thrown"/>
        </dependency>
        <sources>
          <dep name="Thrower"/>
        </sources>
        <targets>
          <dep name="ThrownType"/>
        </targets>
      </link_metaclass>
      <metaclass name="Region" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>� 0  R                
        <dependency name="Parent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="OwnedRegion"/>
        </dependency>
        <dependency name="Represented" min="0" max="1" navigate="false">
          <target fragment="Standard" name="StateMachine"/>
          <opposite name="Top"/>
        </dependency>
        <dependency name="Sub" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="StateVertex"/>
          <opposite name="Parent"/>
        </dependency>
      </metaclass>
      <metaclass name="RequiredInterface" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="RequiredElement" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Interface"/>
          <opposite name="Requiring"/>
        </dependency>
        <dependency name="Provider" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="LinkEnd"/>
          <opposite name="Consumer"/>
        </dependency>
        <dependency name="Requiring" min="1" max="1" navigate="false">
          <target fragment="Standard" name="Port"/>
          <opposite name="Required"/>
        </dependency>
        <dependency name="NaryProvider" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="NaryLinkEnd"/>
          <opposite name="Consumer"/>
        </dependency>
      </metaclass>
      <metaclass name="SendSignalAction" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <dependency name="Sent" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="Sender"/>
        </dependency>
      </metaclass>
      <metaclass name="SequenceDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
      </metaclass>
      <metaclass name="ShallowHistoryPseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="Signal" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
        <attribute name="IsEvent" type="java.lang.Boolean"></attribute>
        <attribute name="IsException" type="java.lang.Boolean"></attribute>
        <dependency name="Sender" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="SendSignalAction"/>
          <opposite name="Sent"/>
        </dependency>
        <dependency name="Usage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Message"/>
          <opposite name="SignalSignature"/>
        </dependency>
        <dependency name="Sends" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Transition"/>
          <opposite name="Effects"/>
        </dependency>
        <dependency name="PBase" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Parameter"/>
          <opposite name="SRepresentation"/>
        </dependency>
        <dependency name="OBase" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="SRepresentation"/>
        </dependency>
        <dependency name="CommunicationUsage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="CommunicationMessage"/>
          <opposite name="SignalSignature"/>
        </dependency>
        <dependency name="DOccurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="DataFlow"/>
          <opposite name="SModel"/>
        </dependency>
        <dependency name="EOccurence" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Event"/>
          <opposite name="Model"/>
        </dependency>
        <dependency name="Base" min="0" max="1" navigate="true">
          <target fragment="Standard" name="GeneralClass"/>
          <opposite name="SRepresentation"/>
        </dependency>
        <dependency name="Receiver" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="AcceptSignalAction"/>
          <opposite name="Accepted"/>
        </dependency>
      </metaclass>
      <metaclass name="State" version="0.0.9054">
        <parent fragment="Standard" name="StateVertex"/>
        <dependency name="ExitPoint" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExitPointPseudoState"/>
          <opposite name="ExitOf"/>
        </dependency>
        <dependency name="BpmnDataStateRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnDataState"/>
          <opposite name="UmlState"/>
        </dependency>
        <dependency name="Deffered" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="Event"/>
          <opposite name="Origin"/>
        </dependency>
        <dependency name="Internal" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="InternalTransition"/>
          <opposite name="SComposed"/>
        </dependency>
        <dependency name="EntryPoint" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="EntryPointPseudoState"/>
          <opposite name="EntryOf"/>
        </dependency>
        <dependency name="OwnedRegion" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Region"/>
          <opposite name="Parent"/>
        </dependency>
        <dependency name="RequiredStateOfBpmnMessage" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnMessage"/>
          <opposite name="InState"/>
        </dependency>
        <dependency name="RequiredStateOf" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ObjectNode"/>
          <opposite name="InState"/>
        </dependency>
        <dependency name="Connection" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ConnectionPointReference"/>
          <opposite name="OwnerState"/>
        </dependency>
        <dependency name="SubMachine" min="0" max="1" navigate="true">
          <target fragment="Standard" name="StateMachine"/>
          <opposite name="SubmachineState"/>
        </dependency>
        <dependency name="RequiredStateOfBpmnItem" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnItemAwareElement"/>
          <opposite name="InState"/>
        </dependency>
      </metaclass>
      <metaclass name="StateInvariant" version="0.0.9054">
        <parent fragment="Standard" name="OccurrenceSpecification"/>
        <attribute name="Body" type="java.lang.String"></attribute>
        <attribute name="EndLineNumber" type="java.lang.Integer"></attribute>
      </metaclass>
      <metaclass name="StateMachine" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="Behavior"/>
        <attribute name="Kind" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.behavior.stateMachineModel.KindOfStateMachine"></attribute>
        <dependency name="Top" min="1" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Region"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="SubmachineState" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="State"/>
          <opposite name="SubMachine"/>
        </dependency>
        <dependency name="EntryPoint" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="EntryPointPseudoState"/>
          <opposite name="EntryOfMachine"/>
        </dependency>
        <dependency name="ExitPoint" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExitPointPseudoS� 0  R                tate"/>
          <opposite name="ExitOfMachine"/>
        </dependency>
      </metaclass>
      <metaclass name="StateMachineDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="BehaviorDiagram"/>
      </metaclass>
      <metaclass name="StateVertex" version="0.0.9054" abstract="true">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="OutGoing" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="Transition"/>
          <opposite name="Source"/>
        </dependency>
        <dependency name="Incoming" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="Transition"/>
          <opposite name="Target"/>
        </dependency>
        <dependency name="Parent" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Region"/>
          <opposite name="Sub"/>
        </dependency>
      </metaclass>
      <metaclass name="StaticDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Infrastructure" name="AbstractDiagram"/>
      </metaclass>
      <metaclass name="StructuralFeature" version="0.0.9054">
        <parent fragment="Standard" name="Feature"/>
        <attribute name="Changeable" type="java.lang.Enum" enumType="org.modelio.metamodel.uml.statik.KindOfAccess"></attribute>
        <attribute name="IsDerived" type="java.lang.Boolean"></attribute>
        <attribute name="IsOrdered" type="java.lang.Boolean"></attribute>
        <attribute name="IsUnique" type="java.lang.Boolean"></attribute>
        <attribute name="MultiplicityMin" type="java.lang.String"></attribute>
        <attribute name="MultiplicityMax" type="java.lang.String"></attribute>
        <dependency name="RealizedInformationFlow" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="RealizingFeature"/>
        </dependency>
      </metaclass>
      <metaclass name="StructuredActivityNode" version="0.0.9054">
        <parent fragment="Standard" name="ActivityAction"/>
        <attribute name="MustIsolate" type="java.lang.Boolean"></attribute>
        <dependency name="Body" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ActivityNode"/>
          <opposite name="OwnerNode"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Substitution" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Contract" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="SubstitutingSubstitution"/>
        </dependency>
        <dependency name="SubstitutingClassifier" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Classifier"/>
          <opposite name="Substitued"/>
        </dependency>
        <sources>
          <dep name="SubstitutingClassifier"/>
        </sources>
        <targets>
          <dep name="Contract"/>
        </targets>
      </link_metaclass>
      <link_metaclass name="TemplateBinding" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="ParameterSubstitution" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="TemplateParameterSubstitution"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="BoundOperation" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="TemplateInstanciation"/>
        </dependency>
        <dependency name="InstanciatedTemplateOperation" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="InstanciatingBinding"/>
        </dependency>
        <dependency name="InstanciatedTemplate" min="0" max="1" navigate="true">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="InstanciatingBinding"/>
        </dependency>
        <dependency name="BoundElement" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="TemplateInstanciation"/>
        </dependency>
        <sources>
          <dep name="BoundOperation"/>
          <dep name="BoundElement"/>
        </sources>
        <targets>
          <dep name="InstanciatedTemplateOperation"/>
          <dep name="InstanciatedTemplate"/>
        </targets>
      </link_metaclass>
      <metaclass name="TemplateParameter" version="0.0.9054">
        <parent fragment="Standard" name="GeneralClass"/>
        <attribute name="DefaultValue" type="java.lang.String"></attribute>
        <attribute name="IsValueParameter" type="java.lang.Boolean"></attribute>
        <dependency name="ParameterSubstitution" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="TemplateParameterSubstitution"/>
          <opposite name="FormalParameter"/>
        </dependency>
        <dependency name="Type" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="TypingParameter"/>
        </dependency>
        <dependency name="Parameterized" min="0" max="1" navigate="false">
          <target fragment="Standard" name="NameSpace"/>
          <opposite name="Template"/>
        </dependency>
        <dependency name="OwnedParameterElement" min="0" max="1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="OwnerTemplateParameter"/>
        </dependency>
        <dependency name="DefaultType" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="DefaultParametering"/>
        </dependency>
        <dependency name="ParameterizedOperation" min="0" max="1" navigate="false">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Template"/>
        </dependency>
      </metaclass>
      <metaclass name="TemplateParameterSubstitution" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Value" type="java.lang.String"></attribute>
        <dependency name="Owner" min="1" max="1" navigate="false">
          <target fragment="Standard" name="TemplateBinding"/>
          <opposite name="ParameterSubstitution"/>
        </dependency>
        <dependency name="Actual" min="0" max="1" navigate="true">
          <target fragment="Standard" name="UmlModelElement"/>
          <opposite name="TemplateSubstitution"/>
        </dependency>
        <dependency name="FormalParameter" min="1" max="1" navigate="true">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="ParameterSubstitution"/>
        </dependency>
      </metaclass>
      <metaclass name="TerminatePseudoState" version="0.0.9054">
        <parent fragment="Standard" name="AbstractPseudoState"/>
      </metaclass>
      <metaclass name="TerminateSpecification" version="0.0.9054">
        <parent fragment="Standard" name="ExecutionOccurenceSpecification"/>
      </metaclass>
      <link_metaclass name="Transition" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <attribute name="Effect" type="java.lang.String"></attribute>
        <attribute name="ReceivedEvents" type="java.lang.String"></attribute>
        <attribute name="SentEvents" type="java.lang.String"></attribute>
        <attribute name="Guard" type="java.lang.String"></attribute>
        <attribute name="PostCondition" type="java.lang.String"></attribute>
        <dependency name="Processed" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Operation"/>
          <opposite name="Invoker"/>
        </dependency>
        <dependency name="Trigger" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Event� 0  R                "/>
          <opposite name="Triggered"/>
        </dependency>
        <dependency name="BehaviorEffect" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Behavior"/>
          <opposite name="EffectOf"/>
        </dependency>
        <dependency name="Target" min="0" max="1" navigate="true">
          <target fragment="Standard" name="StateVertex"/>
          <opposite name="Incoming"/>
        </dependency>
        <dependency name="Source" min="0" max="1" navigate="false">
          <target fragment="Standard" name="StateVertex"/>
          <opposite name="OutGoing"/>
        </dependency>
        <dependency name="Effects" min="0" max="1" navigate="true">
          <target fragment="Standard" name="Signal"/>
          <opposite name="Sends"/>
        </dependency>
        <sources>
          <dep name="Source"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="UmlModelElement" version="0.0.9054" abstract="true">
        <parent fragment="Infrastructure" name="ModelElement"/>
        <dependency name="TemplateSubstitution" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="TemplateParameterSubstitution"/>
          <opposite name="Actual"/>
        </dependency>
        <dependency name="BpmnLaneRefs" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BpmnLane"/>
          <opposite name="PartitionElement"/>
        </dependency>
        <dependency name="DefaultParametering" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="DefaultType"/>
        </dependency>
        <dependency name="Represents" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="Binding"/>
          <opposite name="RepresentedFeature"/>
        </dependency>
        <dependency name="OwnerTemplateParameter" min="0" max="1" navigate="false">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="OwnedParameterElement"/>
        </dependency>
        <dependency name="RepresentingEnd" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ConnectorEnd"/>
          <opposite name="RepresentedFeature"/>
        </dependency>
        <dependency name="RepresentingPartition" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="ActivityPartition"/>
          <opposite name="Represented"/>
        </dependency>
        <dependency name="ConstraintDefinition" min="0" max="-1" aggregation="SharedAggregation" navigate="true" cascadeDelete="true">
          <target fragment="Standard" name="Constraint"/>
          <opposite name="ConstrainedElement"/>
        </dependency>
        <dependency name="TypingParameter" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="TemplateParameter"/>
          <opposite name="Type"/>
        </dependency>
        <dependency name="Manifesting" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="Manifestation"/>
          <opposite name="UtilizedElement"/>
        </dependency>
        <dependency name="RepresentingInstance" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="BindableInstance"/>
          <opposite name="RepresentedFeature"/>
        </dependency>
        <dependency name="ReceivedInfo" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="InformationTarget"/>
        </dependency>
        <dependency name="SentInfo" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="InformationFlow"/>
          <opposite name="InformationSource"/>
        </dependency>
        <dependency name="RepresentingConnector" min="0" max="-1" navigate="false">
          <target fragment="Standard" name="NaryConnector"/>
          <opposite name="RepresentedFeature"/>
        </dependency>
      </metaclass>
      <link_metaclass name="Usage" version="0.0.9054">
        <parent fragment="Infrastructure" name="Dependency"/>
        <sources>
          <dep name="Impacted"/>
        </sources>
        <targets>
          <dep name="DependsOn"/>
        </targets>
      </link_metaclass>
      <metaclass name="UseCase" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="GeneralClass"/>
        <dependency name="Used" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="UseCaseDependency"/>
          <opposite name="Origin"/>
        </dependency>
        <dependency name="OwnedExtension" min="0" max="-1" aggregation="Composition" navigate="true">
          <target fragment="Standard" name="ExtensionPoint"/>
          <opposite name="Owner"/>
        </dependency>
        <dependency name="User" min="0" max="-1" navigate="false" cascadeDelete="true">
          <target fragment="Standard" name="UseCaseDependency"/>
          <opposite name="Target"/>
        </dependency>
      </metaclass>
      <link_metaclass name="UseCaseDependency" version="0.0.9054">
        <parent fragment="Standard" name="UmlModelElement"/>
        <dependency name="Origin" min="1" max="1" navigate="false">
          <target fragment="Standard" name="UseCase"/>
          <opposite name="Used"/>
        </dependency>
        <dependency name="ExtensionLocation" min="0" max="-1" navigate="true">
          <target fragment="Standard" name="ExtensionPoint"/>
          <opposite name="Extended"/>
        </dependency>
        <dependency name="Target" min="1" max="1" navigate="true">
          <target fragment="Standard" name="UseCase"/>
          <opposite name="User"/>
        </dependency>
        <sources>
          <dep name="Origin"/>
        </sources>
        <targets>
          <dep name="Target"/>
        </targets>
      </link_metaclass>
      <metaclass name="UseCaseDiagram" version="0.0.9054" cmsNode="true">
        <parent fragment="Standard" name="StaticDiagram"/>
      </metaclass>
      <metaclass name="ValuePin" version="0.0.9054">
        <parent fragment="Standard" name="InputPin"/>
        <attribute name="Value" type="java.lang.String"></attribute>
      </metaclass>
    </metaclasses>
    <enumerations>
      <enumeration name="org.modelio.metamodel.bpmn.activities.AdHocOrdering">
        <value name="PARALLELORDERING"/>
        <value name="SEQUENTIALORDERING"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.activities.MultiInstanceBehavior">
        <value name="NONEBEHAVIOR"/>
        <value name="ONEBEHAVIOR"/>
        <value name="ALLBEHAVIOR"/>
        <value name="COMPLEXBEHAVIOR"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.activities.TransactionMethod">
        <value name="COMPENSATETRANSACTION"/>
        <value name="STORETRANSACTION"/>
        <value name="IMAGETRANSACTION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGatewayType">
        <value name="PARALLELGATEWAY"/>
        <value name="EXCLUSIVEGATEWAY"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.gateways.BpmnGatewayDirection">
        <value name="UNSPECIFIEDDIRECTION"/>
        <value name="CONVERGINGDIRECTION"/>
        <value name="DIVERGINGDIRECTION"/>
        <value name="MIXEDDIRECTION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.objects.BpmnItemKind">
        <value name="PHYSICAL"/>
        <value name="INFORMATION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.processCollaboration.BpmnProcessType">
        <value name="NONEPROCESS"/>
        <value name="PUBLICPROCESS"/>
        <value name="PRIVATEPROCESS"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.bpmn.processCollaboration.OptionalBoolean">
        <value name="OFALSE"/>
        <value name="OTRUE"/>
        <value name="OUNDEFINED"/>
      </enumeration>
      <en� 0  R              uumeration name="org.modelio.metamodel.bpmn.rootElements.BpmnAssociationDirection">
        <value name="NONEDIRECTION"/>
        <value name="ONEDIRECTION"/>
        <value name="BOTHDIRECTION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.activityModel.DecisionNodeKind">
        <value name="COMPLEXDECISION"/>
        <value name="EXCLUSIVEDECISION"/>
        <value name="INCLUSIVEDECISION"/>
        <value name="EVENTBASEDDECISION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.activityModel.ExpansionKind">
        <value name="PARALLEL"/>
        <value name="ITERATIVE"/>
        <value name="STREAM"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.activityModel.ObjectFlowEffectKind">
        <value name="CREATEFLOW"/>
        <value name="READFLOW"/>
        <value name="UPDATEFLOW"/>
        <value name="DELETEFLOW"/>
        <value name="EXCEPTIONFLOW"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.activityModel.ObjectNodeOrderingKind">
        <value name="UNORDERED"/>
        <value name="ORDERED"/>
        <value name="LIFO"/>
        <value name="FIFO"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.commonBehaviors.EventType">
        <value name="SIGNALEVENT"/>
        <value name="CALLEVENT"/>
        <value name="TIMEEVENT"/>
        <value name="CHANGEEVENT"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind">
        <value name="CREATEEFFECT"/>
        <value name="READEFFECT"/>
        <value name="UPDATEEFFECT"/>
        <value name="DELETEEFFECT"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperator">
        <value name="SEQOP"/>
        <value name="ALTOP"/>
        <value name="OPTOP"/>
        <value name="BREAKOP"/>
        <value name="PAROP"/>
        <value name="STRICTOP"/>
        <value name="LOOPOP"/>
        <value name="CRITICALOP"/>
        <value name="NEGOP"/>
        <value name="ASSERTOP"/>
        <value name="IGNOREOP"/>
        <value name="CONSIDEROP"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.interactionModel.MessageKind">
        <value name="COMPLETEKIND"/>
        <value name="LOSTKIND"/>
        <value name="FOUNDKIND"/>
        <value name="UNKNOWNKIND"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.interactionModel.MessageSort">
        <value name="SYNCCALL"/>
        <value name="ASYNCCALL"/>
        <value name="ASYNCSIGNAL"/>
        <value name="DESTROYMESSAGE"/>
        <value name="CREATEMESSAGE"/>
        <value name="RETURNMESSAGE"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.behavior.stateMachineModel.KindOfStateMachine">
        <value name="DYNAMIC"/>
        <value name="PROTOCOL"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.AggregationKind">
        <value name="KINDISASSOCIATION"/>
        <value name="KINDISAGGREGATION"/>
        <value name="KINDISCOMPOSITION"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.KindOfAccess">
        <value name="READ"/>
        <value name="WRITE"/>
        <value name="READWRITE"/>
        <value name="ACCESNONE"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.MethodPassingMode">
        <value name="METHODIN"/>
        <value name="METHODOUT"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.PassingMode">
        <value name="IN"/>
        <value name="OUT"/>
        <value name="INOUT"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.PortOrientation">
        <value name="NONE"/>
        <value name="IN"/>
        <value name="OUT"/>
        <value name="INOUT"/>
      </enumeration>
      <enumeration name="org.modelio.metamodel.uml.statik.VisibilityMode">
        <value name="PUBLIC"/>
        <value name="PROTECTED"/>
        <value name="PRIVATE"/>
        <value name="VISIBILITYUNDEFINED"/>
        <value name="PACKAGEVISIBILITY"/>
      </enumeration>
    </enumerations>
  </fragment>
  <fragment name="modelio.kernel" version="1.0.00" provider="Modeliosoft" providerVersion="1.0.00">
    <metaclasses>
      <metaclass name="SmObject" version="0.0.00" abstract="true">
        <attribute name="status" type="java.lang.Long"></attribute>
      </metaclass>
    </metaclasses>
    <enumerations></enumerations>
  </fragment>
</metamodel>               Q V�   dx.uses!fmain!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users! �� tlfidx.class.ModuleComponent!fidx.uses!fmain!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users! �� �lfidx.class.ModuleComponent!fidx.uses!fidx.class.DiagramSet!fmain!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users! �� �lfidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.uses!fidx.class.DiagramSet!fmain!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users! �� �l	fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.DiagramSet!fmain!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users! �� �l
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users!    �   ��lfidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fidx.class.StaticDiagram!	fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users!    �   ��#lfidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fidx.class.StaticDiagram!	fmetamodel_descriptor.xml!fFORMAT_VERSION!�f	idx.users!    �   ��Alfidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fmetamodel_descriptor.xml!f	idx.users! fidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.SequenceDiagram!fidx.class.StaticDiagram!	fFORMAT_VERSION!�   �   ��_lfidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fmetamodel_descriptor.xml!f	idx.users! fidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.SequenceDiagram!fidx.class.ActivityDiagram!fidx.class.StaticDiagram!	fFORMAT_VERSION!�   �   ���lfidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fidx.class.CommunicationDiagram!fmetamodel_descriptor.xml!f	idx.users! fidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.SequenceDiagram!fidx.class.ActivityDiagram!fidx.class.StaticDiagram!	fFORMAT_VERSION!�   �   ���lfidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fidx.class.CommunicationDiagram!fmetamodel_descriptor.xml!f	idx.users! fidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.SequenceDiagram!f)idx.class.BpmnProcessCollaborationDiagram!fidx.class.ActivityDiagram!fidx.class.StaticDiagram!	fFORMAT_VERSION!�   �   ���lfidx.class.DiagramSet!fmain!fidx.class.BehaviorDiagram!fidx.class.CommunicationDiagram!fmetamodel_descriptor.xml!f	idx.users! fidx.class.StateMachineDiagram!
fidx.class.ModuleComponent!fidx.class.AbstractDiagram!fidx.class.ImpactDiagram!fidx.uses!fidx.class.SequenceDiagram!f)idx.class.BpmnProcessCollaborationDiagram!fidx.class.Activ