#pragma once

// @generated by torchgen/gen.py from Function.h

#include <ATen/Context.h>
#include <ATen/DeviceGuard.h>
#include <ATen/TensorUtils.h>
#include <ATen/TracerMode.h>
#include <ATen/core/Generator.h>
#include <ATen/core/Reduction.h>
#include <ATen/core/Tensor.h>
#include <c10/core/Scalar.h>
#include <c10/core/Storage.h>
#include <c10/core/TensorOptions.h>
#include <c10/util/Deprecated.h>
#include <c10/util/Optional.h>



#include <ATen/ops/special_chebyshev_polynomial_t_ops.h>

namespace at {


// aten::special_chebyshev_polynomial_t(Tensor x, Tensor n) -> Tensor
inline at::Tensor special_chebyshev_polynomial_t(const at::Tensor & x, const at::Tensor & n) {
    return at::_ops::special_chebyshev_polynomial_t::call(x, n);
}

// aten::special_chebyshev_polynomial_t.x_scalar(Scalar x, Tensor n) -> Tensor
inline at::Tensor special_chebyshev_polynomial_t(const at::Scalar & x, const at::Tensor & n) {
    return at::_ops::special_chebyshev_polynomial_t_x_scalar::call(x, n);
}

// aten::special_chebyshev_polynomial_t.n_scalar(Tensor x, Scalar n) -> Tensor
inline at::Tensor special_chebyshev_polynomial_t(const at::Tensor & x, const at::Scalar & n) {
    return at::_ops::special_chebyshev_polynomial_t_n_scalar::call(x, n);
}

// aten::special_chebyshev_polynomial_t.out(Tensor x, Tensor n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_out(at::Tensor & out, const at::Tensor & x, const at::Tensor & n) {
    return at::_ops::special_chebyshev_polynomial_t_out::call(x, n, out);
}

// aten::special_chebyshev_polynomial_t.out(Tensor x, Tensor n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_outf(const at::Tensor & x, const at::Tensor & n, at::Tensor & out) {
    return at::_ops::special_chebyshev_polynomial_t_out::call(x, n, out);
}

// aten::special_chebyshev_polynomial_t.x_scalar_out(Scalar x, Tensor n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_out(at::Tensor & out, const at::Scalar & x, const at::Tensor & n) {
    return at::_ops::special_chebyshev_polynomial_t_x_scalar_out::call(x, n, out);
}

// aten::special_chebyshev_polynomial_t.x_scalar_out(Scalar x, Tensor n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_outf(const at::Scalar & x, const at::Tensor & n, at::Tensor & out) {
    return at::_ops::special_chebyshev_polynomial_t_x_scalar_out::call(x, n, out);
}

// aten::special_chebyshev_polynomial_t.n_scalar_out(Tensor x, Scalar n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_out(at::Tensor & out, const at::Tensor & x, const at::Scalar & n) {
    return at::_ops::special_chebyshev_polynomial_t_n_scalar_out::call(x, n, out);
}

// aten::special_chebyshev_polynomial_t.n_scalar_out(Tensor x, Scalar n, *, Tensor(a!) out) -> Tensor(a!)
inline at::Tensor & special_chebyshev_polynomial_t_outf(const at::Tensor & x, const at::Scalar & n, at::Tensor & out) {
    return at::_ops::special_chebyshev_polynomial_t_n_scalar_out::call(x, n, out);
}

}