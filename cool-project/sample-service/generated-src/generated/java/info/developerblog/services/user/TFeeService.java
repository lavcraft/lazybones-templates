/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package info.developerblog.services.user;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-10-11")
public class TFeeService {

  public interface Iface {

    public TFee calculateFee(info.developerblog.services.auth.TUser user, int hippoCount) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void calculateFee(info.developerblog.services.auth.TUser user, int hippoCount, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public TFee calculateFee(info.developerblog.services.auth.TUser user, int hippoCount) throws org.apache.thrift.TException
    {
      send_calculateFee(user, hippoCount);
      return recv_calculateFee();
    }

    public void send_calculateFee(info.developerblog.services.auth.TUser user, int hippoCount) throws org.apache.thrift.TException
    {
      calculateFee_args args = new calculateFee_args();
      args.setUser(user);
      args.setHippoCount(hippoCount);
      sendBase("calculateFee", args);
    }

    public TFee recv_calculateFee() throws org.apache.thrift.TException
    {
      calculateFee_result result = new calculateFee_result();
      receiveBase(result, "calculateFee");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "calculateFee failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void calculateFee(info.developerblog.services.auth.TUser user, int hippoCount, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
      checkReady();
      calculateFee_call method_call = new calculateFee_call(user, hippoCount, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class calculateFee_call extends org.apache.thrift.async.TAsyncMethodCall {
      private info.developerblog.services.auth.TUser user;
      private int hippoCount;
      public calculateFee_call(info.developerblog.services.auth.TUser user, int hippoCount, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.user = user;
        this.hippoCount = hippoCount;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("calculateFee", org.apache.thrift.protocol.TMessageType.CALL, 0));
        calculateFee_args args = new calculateFee_args();
        args.setUser(user);
        args.setHippoCount(hippoCount);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public TFee getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_calculateFee();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("calculateFee", new calculateFee());
      return processMap;
    }

    public static class calculateFee<I extends Iface> extends org.apache.thrift.ProcessFunction<I, calculateFee_args> {
      public calculateFee() {
        super("calculateFee");
      }

      public calculateFee_args getEmptyArgsInstance() {
        return new calculateFee_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public calculateFee_result getResult(I iface, calculateFee_args args) throws org.apache.thrift.TException {
        calculateFee_result result = new calculateFee_result();
        result.success = iface.calculateFee(args.user, args.hippoCount);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("calculateFee", new calculateFee());
      return processMap;
    }

    public static class calculateFee<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, calculateFee_args, TFee> {
      public calculateFee() {
        super("calculateFee");
      }

      public calculateFee_args getEmptyArgsInstance() {
        return new calculateFee_args();
      }

      public AsyncMethodCallback<TFee> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<TFee>() { 
          public void onComplete(TFee o) {
            calculateFee_result result = new calculateFee_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            calculateFee_result result = new calculateFee_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, calculateFee_args args, org.apache.thrift.async.AsyncMethodCallback<TFee> resultHandler) throws TException {
        iface.calculateFee(args.user, args.hippoCount,resultHandler);
      }
    }

  }

  public static class calculateFee_args implements org.apache.thrift.TBase<calculateFee_args, calculateFee_args._Fields>, java.io.Serializable, Cloneable, Comparable<calculateFee_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("calculateFee_args");

    private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRUCT, (short)1);
    private static final org.apache.thrift.protocol.TField HIPPO_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("hippoCount", org.apache.thrift.protocol.TType.I32, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new calculateFee_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new calculateFee_argsTupleSchemeFactory());
    }

    private info.developerblog.services.auth.TUser user; // required
    private int hippoCount; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      USER((short)1, "user"),
      HIPPO_COUNT((short)2, "hippoCount");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // USER
            return USER;
          case 2: // HIPPO_COUNT
            return HIPPO_COUNT;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __HIPPOCOUNT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.REQUIRED, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, info.developerblog.services.auth.TUser.class)));
      tmpMap.put(_Fields.HIPPO_COUNT, new org.apache.thrift.meta_data.FieldMetaData("hippoCount", org.apache.thrift.TFieldRequirementType.REQUIRED, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(calculateFee_args.class, metaDataMap);
    }

    public calculateFee_args() {
    }

    public calculateFee_args(
      info.developerblog.services.auth.TUser user,
      int hippoCount)
    {
      this();
      this.user = user;
      this.hippoCount = hippoCount;
      setHippoCountIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public calculateFee_args(calculateFee_args other) {
      __isset_bitfield = other.__isset_bitfield;
      if (other.isSetUser()) {
        this.user = new info.developerblog.services.auth.TUser(other.user);
      }
      this.hippoCount = other.hippoCount;
    }

    public calculateFee_args deepCopy() {
      return new calculateFee_args(this);
    }

    @Override
    public void clear() {
      this.user = null;
      setHippoCountIsSet(false);
      this.hippoCount = 0;
    }

    public info.developerblog.services.auth.TUser getUser() {
      return this.user;
    }

    public calculateFee_args setUser(info.developerblog.services.auth.TUser user) {
      this.user = user;
      return this;
    }

    public void unsetUser() {
      this.user = null;
    }

    /** Returns true if field user is set (has been assigned a value) and false otherwise */
    public boolean isSetUser() {
      return this.user != null;
    }

    public void setUserIsSet(boolean value) {
      if (!value) {
        this.user = null;
      }
    }

    public int getHippoCount() {
      return this.hippoCount;
    }

    public calculateFee_args setHippoCount(int hippoCount) {
      this.hippoCount = hippoCount;
      setHippoCountIsSet(true);
      return this;
    }

    public void unsetHippoCount() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HIPPOCOUNT_ISSET_ID);
    }

    /** Returns true if field hippoCount is set (has been assigned a value) and false otherwise */
    public boolean isSetHippoCount() {
      return EncodingUtils.testBit(__isset_bitfield, __HIPPOCOUNT_ISSET_ID);
    }

    public void setHippoCountIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HIPPOCOUNT_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case USER:
        if (value == null) {
          unsetUser();
        } else {
          setUser((info.developerblog.services.auth.TUser)value);
        }
        break;

      case HIPPO_COUNT:
        if (value == null) {
          unsetHippoCount();
        } else {
          setHippoCount((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case USER:
        return getUser();

      case HIPPO_COUNT:
        return Integer.valueOf(getHippoCount());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case USER:
        return isSetUser();
      case HIPPO_COUNT:
        return isSetHippoCount();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof calculateFee_args)
        return this.equals((calculateFee_args)that);
      return false;
    }

    public boolean equals(calculateFee_args that) {
      if (that == null)
        return false;

      boolean this_present_user = true && this.isSetUser();
      boolean that_present_user = true && that.isSetUser();
      if (this_present_user || that_present_user) {
        if (!(this_present_user && that_present_user))
          return false;
        if (!this.user.equals(that.user))
          return false;
      }

      boolean this_present_hippoCount = true;
      boolean that_present_hippoCount = true;
      if (this_present_hippoCount || that_present_hippoCount) {
        if (!(this_present_hippoCount && that_present_hippoCount))
          return false;
        if (this.hippoCount != that.hippoCount)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_user = true && (isSetUser());
      list.add(present_user);
      if (present_user)
        list.add(user);

      boolean present_hippoCount = true;
      list.add(present_hippoCount);
      if (present_hippoCount)
        list.add(hippoCount);

      return list.hashCode();
    }

    @Override
    public int compareTo(calculateFee_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetUser()).compareTo(other.isSetUser());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetUser()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, other.user);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetHippoCount()).compareTo(other.isSetHippoCount());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetHippoCount()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hippoCount, other.hippoCount);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("calculateFee_args(");
      boolean first = true;

      sb.append("user:");
      if (this.user == null) {
        sb.append("null");
      } else {
        sb.append(this.user);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("hippoCount:");
      sb.append(this.hippoCount);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      if (user == null) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'user' was not present! Struct: " + toString());
      }
      // alas, we cannot check 'hippoCount' because it's a primitive and you chose the non-beans generator.
      // check for sub-struct validity
      if (user != null) {
        user.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class calculateFee_argsStandardSchemeFactory implements SchemeFactory {
      public calculateFee_argsStandardScheme getScheme() {
        return new calculateFee_argsStandardScheme();
      }
    }

    private static class calculateFee_argsStandardScheme extends StandardScheme<calculateFee_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, calculateFee_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // USER
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.user = new info.developerblog.services.auth.TUser();
                struct.user.read(iprot);
                struct.setUserIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // HIPPO_COUNT
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.hippoCount = iprot.readI32();
                struct.setHippoCountIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        if (!struct.isSetHippoCount()) {
          throw new org.apache.thrift.protocol.TProtocolException("Required field 'hippoCount' was not found in serialized data! Struct: " + toString());
        }
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, calculateFee_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.user != null) {
          oprot.writeFieldBegin(USER_FIELD_DESC);
          struct.user.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldBegin(HIPPO_COUNT_FIELD_DESC);
        oprot.writeI32(struct.hippoCount);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class calculateFee_argsTupleSchemeFactory implements SchemeFactory {
      public calculateFee_argsTupleScheme getScheme() {
        return new calculateFee_argsTupleScheme();
      }
    }

    private static class calculateFee_argsTupleScheme extends TupleScheme<calculateFee_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, calculateFee_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        struct.user.write(oprot);
        oprot.writeI32(struct.hippoCount);
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, calculateFee_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        struct.user = new info.developerblog.services.auth.TUser();
        struct.user.read(iprot);
        struct.setUserIsSet(true);
        struct.hippoCount = iprot.readI32();
        struct.setHippoCountIsSet(true);
      }
    }

  }

  public static class calculateFee_result implements org.apache.thrift.TBase<calculateFee_result, calculateFee_result._Fields>, java.io.Serializable, Cloneable, Comparable<calculateFee_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("calculateFee_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new calculateFee_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new calculateFee_resultTupleSchemeFactory());
    }

    private TFee success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TFee.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(calculateFee_result.class, metaDataMap);
    }

    public calculateFee_result() {
    }

    public calculateFee_result(
      TFee success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public calculateFee_result(calculateFee_result other) {
      if (other.isSetSuccess()) {
        this.success = new TFee(other.success);
      }
    }

    public calculateFee_result deepCopy() {
      return new calculateFee_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public TFee getSuccess() {
      return this.success;
    }

    public calculateFee_result setSuccess(TFee success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((TFee)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof calculateFee_result)
        return this.equals((calculateFee_result)that);
      return false;
    }

    public boolean equals(calculateFee_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true && (isSetSuccess());
      list.add(present_success);
      if (present_success)
        list.add(success);

      return list.hashCode();
    }

    @Override
    public int compareTo(calculateFee_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("calculateFee_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class calculateFee_resultStandardSchemeFactory implements SchemeFactory {
      public calculateFee_resultStandardScheme getScheme() {
        return new calculateFee_resultStandardScheme();
      }
    }

    private static class calculateFee_resultStandardScheme extends StandardScheme<calculateFee_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, calculateFee_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new TFee();
                struct.success.read(iprot);
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, calculateFee_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class calculateFee_resultTupleSchemeFactory implements SchemeFactory {
      public calculateFee_resultTupleScheme getScheme() {
        return new calculateFee_resultTupleScheme();
      }
    }

    private static class calculateFee_resultTupleScheme extends TupleScheme<calculateFee_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, calculateFee_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, calculateFee_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = new TFee();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
