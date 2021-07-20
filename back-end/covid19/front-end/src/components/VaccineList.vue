<template>
	<div>
		<v-simple-table>
			<template v-slot:default>
				<thead>
					<tr>
						<th class="text-left">
							회원명
						</th>
						<th class="text-left">
							백신종류
						</th>
						<th class="text-left">
							상태
						</th>
						<th class="text-left">
							날짜
						</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="item in items" :key="item.name">
						<td>{{ item.userName }}</td>
						<td>{{ item.orderName }}</td>
						<td>{{ item.orderStatus }}</td>
						<td>{{ `${item.orderDate.slice(0, 10)}` }}</td>
						<v-container>
							<v-btn
								@click="deleteOrder(item.orderId)"
								v-if="isAdmin"
								color="primary"
							>
								취소
							</v-btn>
							<v-btn @click="cancelOrder(item.orderId)" color="primary">
								대기
							</v-btn>
							<v-btn
								@click="finishOrder(item.orderId)"
								v-if="isAdmin"
								color="primary"
							>
								완료
							</v-btn>
						</v-container>
					</tr>
				</tbody>
			</template>
		</v-simple-table>
	</div>
</template>
<script>
import {
	fetchOrders,
	cancelOrderVaccine,
	deletelOrderVaccine,
	completeOrderVaccine,
} from '@/api/covid';

export default {
	data() {
		return {
			items: [],
			oneOrderId: 0,
		};
	},
	computed: {
		isAdmin() {
			return this.$store.state.name == 'admin@naver.com';
		},
	},
	async mounted() {
		const { data } = await fetchOrders();
		console.log(data);
		this.items = data;
	},

	methods: {
		// 예약 취소
		async cancelOrder(orderId) {
			await cancelOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
		// 예약 삭제
		async deleteOrder(orderId) {
			var con_test = confirm('정말로 취소 하시겠습니까?');
			if (con_test == true) {
				await deletelOrderVaccine(orderId);
				// 데이터 변경사항 적용
				const { data } = await fetchOrders();
				this.items = data;
			} else if (con_test == false) {
				console.log('취소');
			}
		},

		// 접종 완료
		async finishOrder(orderId) {
			await completeOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
	},
};
</script>
