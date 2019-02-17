package jp.co.stah.kodeintest.domain.interactor

import arrow.core.Either

abstract class UseCase<in Params, out ReturnType> where ReturnType : Any {

    abstract fun run(params: Params): Either<Error, ReturnType>
}
