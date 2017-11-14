require 'vertx-bridge-common/base_bridge_event'
require 'vertx/future'
require 'vertx/net_socket'
require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.eventbus.bridge.tcp.BridgeEvent
module VertxTcpEventbusBridge
  #  Represents an event that occurs on the event bus bridge.
  #  <p>
  #  Please consult the documentation for a full explanation.
  class BridgeEvent < ::VertxBridgeCommon::BaseBridgeEvent
    # @private
    # @param j_del [::VertxTcpEventbusBridge::BridgeEvent] the java delegate
    def initialize(j_del)
      super(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxTcpEventbusBridge::BridgeEvent] the underlying java delegate
    def j_del
      @j_del
    end
    @@j_api_type = Object.new
    def @@j_api_type.accept?(obj)
      obj.class == BridgeEvent
    end
    def @@j_api_type.wrap(obj)
      BridgeEvent.new(obj)
    end
    def @@j_api_type.unwrap(obj)
      obj.j_del
    end
    def self.j_api_type
      @@j_api_type
    end
    def self.j_class
      Java::IoVertxExtEventbusBridgeTcp::BridgeEvent.java_class
    end
    # @return [true,false]
    def complete?
      if !block_given?
        return @j_del.java_method(:isComplete, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling complete?()"
    end
    # @yield 
    # @return [self]
    def set_handler
      if block_given?
        @j_del.java_method(:setHandler, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling set_handler()"
    end
    # @param [true,false] arg0 
    # @return [void]
    def complete(arg0=nil)
      if !block_given? && arg0 == nil
        return @j_del.java_method(:complete, []).call()
      elsif (arg0.class == TrueClass || arg0.class == FalseClass) && !block_given?
        return @j_del.java_method(:complete, [Java::JavaLang::Boolean.java_class]).call(arg0)
      end
      raise ArgumentError, "Invalid arguments when calling complete(#{arg0})"
    end
    # @overload fail(arg0)
    #   @param [Exception] arg0 
    # @overload fail(arg0)
    #   @param [String] arg0 
    # @return [void]
    def fail(param_1=nil)
      if param_1.is_a?(Exception) && !block_given?
        return @j_del.java_method(:fail, [Java::JavaLang::Throwable.java_class]).call(::Vertx::Util::Utils.to_throwable(param_1))
      elsif param_1.class == String && !block_given?
        return @j_del.java_method(:fail, [Java::java.lang.String.java_class]).call(param_1)
      end
      raise ArgumentError, "Invalid arguments when calling fail(#{param_1})"
    end
    # @param [true,false] arg0 
    # @return [true,false]
    def try_complete?(arg0=nil)
      if !block_given? && arg0 == nil
        return @j_del.java_method(:tryComplete, []).call()
      elsif (arg0.class == TrueClass || arg0.class == FalseClass) && !block_given?
        return @j_del.java_method(:tryComplete, [Java::JavaLang::Boolean.java_class]).call(arg0)
      end
      raise ArgumentError, "Invalid arguments when calling try_complete?(#{arg0})"
    end
    # @overload tryFail(arg0)
    #   @param [Exception] arg0 
    # @overload tryFail(arg0)
    #   @param [String] arg0 
    # @return [true,false]
    def try_fail?(param_1=nil)
      if param_1.is_a?(Exception) && !block_given?
        return @j_del.java_method(:tryFail, [Java::JavaLang::Throwable.java_class]).call(::Vertx::Util::Utils.to_throwable(param_1))
      elsif param_1.class == String && !block_given?
        return @j_del.java_method(:tryFail, [Java::java.lang.String.java_class]).call(param_1)
      end
      raise ArgumentError, "Invalid arguments when calling try_fail?(#{param_1})"
    end
    # @return [true,false]
    def result?
      if !block_given?
        return @j_del.java_method(:result, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling result?()"
    end
    # @return [Exception]
    def cause
      if !block_given?
        return ::Vertx::Util::Utils.from_throwable(@j_del.java_method(:cause, []).call())
      end
      raise ArgumentError, "Invalid arguments when calling cause()"
    end
    # @return [true,false]
    def succeeded?
      if !block_given?
        return @j_del.java_method(:succeeded, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling succeeded?()"
    end
    # @return [true,false]
    def failed?
      if !block_given?
        return @j_del.java_method(:failed, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling failed?()"
    end
    # @overload compose(mapper)
    #   @yield 
    # @overload compose(handler,next)
    #   @param [Proc] handler 
    #   @param [::Vertx::Future] _next 
    # @return [::Vertx::Future]
    def compose(param_1=nil,param_2=nil)
      if block_given? && param_1 == nil && param_2 == nil
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:compose, [Java::JavaUtilFunction::Function.java_class]).call((Proc.new { |event| yield(event).j_del })),::Vertx::Future, nil)
      elsif param_1.class == Proc && param_2.class.method_defined?(:j_del) && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:compose, [Java::IoVertxCore::Handler.java_class,Java::IoVertxCore::Future.java_class]).call((Proc.new { |event| param_1.call(event) }),param_2.j_del),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling compose(#{param_1},#{param_2})"
    end
    # @overload map(mapper)
    #   @yield 
    # @overload map(value)
    #   @param [Object] value 
    # @return [::Vertx::Future]
    def map(param_1=nil)
      if block_given? && param_1 == nil
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:map, [Java::JavaUtilFunction::Function.java_class]).call((Proc.new { |event| ::Vertx::Util::Utils.to_object(yield(event)) })),::Vertx::Future, nil)
      elsif ::Vertx::Util::unknown_type.accept?(param_1) && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:map, [Java::java.lang.Object.java_class]).call(::Vertx::Util::Utils.to_object(param_1)),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling map(#{param_1})"
    end
    # @return [::Vertx::Future]
    def map_empty
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:mapEmpty, []).call(),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling map_empty()"
    end
    # @return [Proc]
    def completer
      if !block_given?
        if @cached_completer != nil
          return @cached_completer
        end
        return @cached_completer = ::Vertx::Util::Utils.to_async_result_handler_proc(@j_del.java_method(:completer, []).call()) { |val| val }
      end
      raise ArgumentError, "Invalid arguments when calling completer()"
    end
    # @yield 
    # @return [::Vertx::Future]
    def recover(mapper=nil)
      if block_given? && mapper == nil
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:recover, [Java::JavaUtilFunction::Function.java_class]).call((Proc.new { |event| yield(::Vertx::Util::Utils.from_throwable(event)).j_del })),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling recover(#{mapper})"
    end
    # @overload otherwise(mapper)
    #   @yield 
    # @overload otherwise(value)
    #   @param [true,false] value 
    # @return [::Vertx::Future]
    def otherwise(param_1=nil)
      if block_given? && param_1 == nil
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:otherwise, [Java::JavaUtilFunction::Function.java_class]).call((Proc.new { |event| yield(::Vertx::Util::Utils.from_throwable(event)) })),::Vertx::Future, nil)
      elsif (param_1.class == TrueClass || param_1.class == FalseClass) && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:otherwise, [Java::JavaLang::Boolean.java_class]).call(param_1),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling otherwise(#{param_1})"
    end
    # @return [::Vertx::Future]
    def otherwise_empty
      if !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:otherwiseEmpty, []).call(),::Vertx::Future, nil)
      end
      raise ArgumentError, "Invalid arguments when calling otherwise_empty()"
    end
    # @return [:SOCKET_CREATED,:SOCKET_CLOSED,:SOCKET_IDLE,:SOCKET_PING,:SEND,:PUBLISH,:RECEIVE,:REGISTER,:UNREGISTER]
    def type
      if !block_given?
        if @cached_type != nil
          return @cached_type
        end
        return @cached_type = @j_del.java_method(:type, []).call().name.intern
      end
      raise ArgumentError, "Invalid arguments when calling type()"
    end
    # @return [Hash{String => Object}]
    def get_raw_message
      if !block_given?
        return @j_del.java_method(:getRawMessage, []).call() != nil ? JSON.parse(@j_del.java_method(:getRawMessage, []).call().encode) : nil
      end
      raise ArgumentError, "Invalid arguments when calling get_raw_message()"
    end
    #  Get the raw JSON message for the event. This will be null for SOCKET_CREATED or SOCKET_CLOSED events as there is
    #  no message involved.
    # @param [Hash{String => Object}] message the raw message
    # @return [self]
    def set_raw_message(message=nil)
      if message.class == Hash && !block_given?
        @j_del.java_method(:setRawMessage, [Java::IoVertxCoreJson::JsonObject.java_class]).call(::Vertx::Util::Utils.to_json_object(message))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling set_raw_message(#{message})"
    end
    #  Get the SockJSSocket instance corresponding to the event
    # @return [::Vertx::NetSocket] the SockJSSocket instance
    def socket
      if !block_given?
        if @cached_socket != nil
          return @cached_socket
        end
        return @cached_socket = ::Vertx::Util::Utils.safe_create(@j_del.java_method(:socket, []).call(),::Vertx::NetSocket)
      end
      raise ArgumentError, "Invalid arguments when calling socket()"
    end
  end
end
