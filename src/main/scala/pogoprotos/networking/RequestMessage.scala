package pogoprotos.networking

import com.trueaccord.scalapb.{Message, GeneratedMessage}

trait RequestMessage[ResponseT <: ResponseMessage with Message[ResponseT] with GeneratedMessage]

