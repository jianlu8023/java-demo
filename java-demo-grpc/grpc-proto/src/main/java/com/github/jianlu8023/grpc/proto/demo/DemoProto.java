// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: demo.proto

package com.github.jianlu8023.grpc.proto.demo;

public final class DemoProto {
  private DemoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DemoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DemoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DemoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DemoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ndemo.proto\"\032\n\013DemoRequest\022\013\n\003msg\030\001 \001(\t" +
      "\"\033\n\014DemoResponse\022\013\n\003msg\030\001 \001(\t22\n\013DemoSer" +
      "vice\022#\n\004demo\022\014.DemoRequest\032\r.DemoRespons" +
      "eB4\n%com.github.jianlu8023.grpc.proto.de" +
      "moB\tDemoProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_DemoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_DemoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DemoRequest_descriptor,
        new java.lang.String[] { "Msg", });
    internal_static_DemoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_DemoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DemoResponse_descriptor,
        new java.lang.String[] { "Msg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
