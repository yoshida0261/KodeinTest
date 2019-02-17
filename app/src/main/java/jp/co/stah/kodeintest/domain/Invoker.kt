package jp.co.stah.kodeintest.domain

import arrow.core.Either
import jp.co.stah.kodeintest.domain.interactor.UseCase

interface Invoker {
    fun <Params, Type : Any> execute(useCase: UseCase<Params, Type>,
                                     params: Params,
                                     onResult: (Either<Error, Type>) -> Unit)
}