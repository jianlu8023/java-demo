// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ping.proto

package com.github.jianlu8023.grpc.proto.ping;

public final class PingProto {
  private PingProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_model_Ping_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_model_Ping_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_model_Pong_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_model_Pong_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nping.proto\022\005model\"3\n\004Ping\022\n\n\002id\030\001 \001(\003\022" +
      "\017\n\007message\030\002 \001(\t\022\016\n\006ipaddr\030\003 \001(\t\"3\n\004Pong" +
      "\022\n\n\002id\030\001 \001(\003\022\017\n\007message\030\002 \001(\t\022\016\n\006ipaddr\030" +
      "\003 \001(\t21\n\013PingService\022\"\n\004ping\022\013.model.Pin" +
      "g\032\013.model.Pong\"\000B4\n%com.github.jianlu802" +
      "3.grpc.proto.pingB\tPingProtoP\001b\006proto3"
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
    internal_static_model_Ping_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_model_Ping_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_model_Ping_descriptor,
        new java.lang.String[] { "Id", "Message", "Ipaddr", });
    internal_static_model_Pong_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_model_Pong_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_model_Pong_descriptor,
        new java.lang.String[] { "Id", "Message", "Ipaddr", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}